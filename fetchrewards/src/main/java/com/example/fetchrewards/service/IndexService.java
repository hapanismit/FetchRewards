package com.example.fetchrewards.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.example.fetchrewards.model.Payer;
import com.example.fetchrewards.model.Points;
import com.example.fetchrewards.model.Transaction;
import com.example.fetchrewards.model.User;

import org.springframework.stereotype.Service;

@Service
public class IndexService {
    
    private static final User user = new User();
    List<Payer> pointsSpentPerPayer = new ArrayList<>();
    
    public Transaction addTrans(Transaction transactions){
        
        String payer = transactions.getPayer();
        Long points = transactions.getPoints();
        Map<String, Long> pointsPerPayer = user.getPointsPerPayer();//points per payer

        PriorityQueue<Transaction> transactionsQueue = user.getTransactionsQueue();//User transaction
        
        transactionsQueue.offer(transactions);
        
        if(points<0) {
            if (!pointsPerPayer.containsKey(payer))
                throw new RuntimeException("Invalid transaction record");
            else if ((pointsPerPayer.get(payer) + points) < 0)
                throw new RuntimeException("Invalid transaction record");
        }
        
        //Update total points
        user.setTotalRewardPoints(user.getTotalRewardPoints() + points);

        //Update Points Per Payer
        pointsPerPayer.put(transactions.getPayer(),(pointsPerPayer.getOrDefault(transactions.getPayer(), 0L).longValue() + points));

        return transactions;
    }

    public List<Payer> spend(Points points){

        Long point = points.getPoints();   
        Map<String, Long> pointsPerPayer = user.getPointsPerPayer();
        PriorityQueue<Transaction> transactionsQ = user.getTransactionsQueue();
        Long totalPoints = user.getTotalRewardPoints();

        if(point > totalPoints) throw new RuntimeException("Points are not sufficient!");

        while(point > 0 && !transactionsQ.isEmpty()){
            
            Transaction curTransactions = transactionsQ.poll();
            Long curSpent;
            Long curPoint = curTransactions.getPoints();
            String curPayer = curTransactions.getPayer();

            if(curPoint <= point)
                curSpent = curPoint;
            else
                curSpent = point;
          
            Payer plr = pointsSpentPerPayer.stream()
                                        .filter(p -> p.getPayer().equals(curPayer)).findFirst().orElse(null);
            
            if(plr != null){ // If payer alredy exits in pointsSpentPerPayer
                pointsSpentPerPayer.remove(plr);
                Long plrPoint = plr.getPoints();
                plr.setPoints(plrPoint + (-1 * curSpent));
                pointsSpentPerPayer.add(plr);
            }else
                pointsSpentPerPayer.add(new Payer(curTransactions.getPayer(),(-1 * curSpent)));
            
            //Update total points
            user.setTotalRewardPoints(user.getTotalRewardPoints() - curSpent);

            //Update Points Per Payer
            pointsPerPayer.put(curPayer,
                                (pointsPerPayer.getOrDefault(curPayer, 0L).longValue() - curSpent)
                            );
            point -= curPoint;
        }
        return pointsSpentPerPayer;
    }
    
    public Map<String, Long> balance(){
        return user.getPointsPerPayer();
    }
}