package com.example.fetchrewards.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class User {

    private Long totalRewardPoints;
    private Map<String, Long> pointsPerPayer;
    private PriorityQueue<Transaction> transactionsQueue;

    public User() {
        //this.userId = id;
        this.totalRewardPoints = 0L;
        this.pointsPerPayer = new HashMap<>();
        this.transactionsQueue = new PriorityQueue<>(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.getTimestamp().compareTo(o2.getTimestamp());
            }
        });
    }

    public Long getTotalRewardPoints() {
        return totalRewardPoints;
    }

    public void setTotalRewardPoints(Long totalRewardPoints) {
        this.totalRewardPoints = totalRewardPoints;
    }

    public Map<String, Long> getPointsPerPayer() {
        return pointsPerPayer;
    }

    public void setPointsPerPayer(Map<String, Long> pointsPerPayer) {
        this.pointsPerPayer = pointsPerPayer;
    }

    public PriorityQueue<Transaction> getTransactionsQueue() {
        return transactionsQueue;
    }

    public void setTransactionsQueue(PriorityQueue<Transaction> transactionsQueue) {
        this.transactionsQueue = transactionsQueue;
    }
}