package com.oprow.bo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class User {

    private long id;
    private String email;
    private String name;

    // Public methods

    public User() { }

    public User(long id) {
        this.id = id;
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    // Getter and setter methods


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Override of the toString method

    @Override
    public String toString(){
        return "The id is : " + this.id + " , the name is : " + this.name + " , the email is : " + this.email;
    }

    // MapIn and MapOut

    public int mapOut(PreparedStatement pPreparedStatement) throws SQLException {
        int lIterator = 1;
        pPreparedStatement.setString(lIterator++, this.name);
        pPreparedStatement.setString(lIterator++, this.email);
        return lIterator;
    }

    public static User mapIn(ResultSet pResultSet) throws SQLException {
        User lUser = new User();
        lUser.id = pResultSet.getInt("id");
        lUser.name = pResultSet.getString("name");
        lUser.email = pResultSet.getString("email");

        return lUser;
    }
}
