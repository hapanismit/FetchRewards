package com.example.fetchrewards.controller;

import java.util.List;
import java.util.Map;

import com.example.fetchrewards.model.Payer;
import com.example.fetchrewards.model.Points;
import com.example.fetchrewards.model.Transaction;
import com.example.fetchrewards.service.IndexService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @PostMapping("/transaction/add/")
    public ResponseEntity<Transaction> addTransactions(@RequestBody Transaction transactions){        
        indexService.addTrans(transactions);
        return ResponseEntity.ok().body(transactions);
    } 

    @PostMapping("/spend/")
    public ResponseEntity<List<Payer>> spendPoints(@RequestBody Points points){
        List<Payer> payers = indexService.spend(points);
        return ResponseEntity.ok().body(payers);
    }

    @GetMapping("/balance/")
    public ResponseEntity<Map<String, Long>> getBalance(){
        Map<String, Long> payers = indexService.balance();
        return ResponseEntity.ok().body(payers);
    }
}