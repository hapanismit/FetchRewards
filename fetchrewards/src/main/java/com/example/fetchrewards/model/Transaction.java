package com.example.fetchrewards.model;
import java.time.Instant;

public class Transaction {

    private String payer;
    private Long points;
    private Instant timestamp;

    public String getPayer() {
        return payer;
    }

    public void setPayerName(String payer) {
        this.payer = payer;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}