package com.oprow.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Administration {

    protected int id;
    protected Date openingTime;
    protected Date closingTime;
    protected String name;
    protected int estimatedWaitingTime;
    protected List<Integer> affluence;

    public int getId() {
        return id;
    }

    public void generateRandomValues() {

        this.affluence = new ArrayList<>();

        this.affluence.add((int)(Math.random() * 100));
        this.affluence.add((this.affluence.get(this.affluence.size()-1)) + (-5)  + (int)(Math.random() * 10));
        this.affluence.add((this.affluence.get(this.affluence.size()-1)) + (-5)  + (int)(Math.random() * 10));
        this.affluence.add((this.affluence.get(this.affluence.size()-1)) + (-5)  + (int)(Math.random() * 10));
        this.affluence.add((this.affluence.get(this.affluence.size()-1)) + (-5)  + (int)(Math.random() * 10));
        this.affluence.add((this.affluence.get(this.affluence.size()-1)) + (-5)  + (int)(Math.random() * 10));
        this.affluence.add((this.affluence.get(this.affluence.size()-1)) + (-5)  + (int)(Math.random() * 10));
        this.affluence.add((this.affluence.get(this.affluence.size()-1)) + (-5)  + (int)(Math.random() * 10));
        this.affluence.add((this.affluence.get(this.affluence.size()-1)) + (-5)  + (int)(Math.random() * 10));
        this.affluence.add((this.affluence.get(this.affluence.size()-1)) + (-5)  + (int)(Math.random() * 10));
        this.affluence.add((this.affluence.get(this.affluence.size()-1)) + (-5)  + (int)(Math.random() * 10));
        this.affluence.add((this.affluence.get(this.affluence.size()-1)) + (-5)  + (int)(Math.random() * 10));
        this.affluence.add((this.affluence.get(this.affluence.size()-1)) + (-5)  + (int)(Math.random() * 10));

    }

    public List<Integer> getAffluence() {
        return affluence;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstimatedWaitingTime() {
        return estimatedWaitingTime;
    }

    public void setEstimatedWaitingTime(int estimatedWaitingTime) {
        this.estimatedWaitingTime = estimatedWaitingTime;
    }
}
