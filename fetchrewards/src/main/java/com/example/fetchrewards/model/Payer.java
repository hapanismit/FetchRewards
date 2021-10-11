package com.example.fetchrewards.model;

public class Payer {
    private String payer;
    private Long points;

    public Payer(String payer, Long points) {
        this.payer = payer;
        this.points = points;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
}