package com.oprow.bo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Affluence {

    protected int adminId;
    protected String adminName;
    protected Timestamp date;
    protected List<Integer> affluence;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public List<Integer> getAffluence() {
        return affluence;
    }

    public void setAffluence(List<Integer> affluence) {
        this.affluence = affluence;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    //Methods

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
}
