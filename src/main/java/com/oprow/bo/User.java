package com.oprow.bo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class User {

    private long id;
    private String email;
    private String name;
    private String surname;
    private Timestamp birthDate;
    private int gender;

    // Public methods

    public User() { }

    public User(long id) {
        this.id = id;
    }

    public User(String email, String name, String surname, Timestamp birthDate, int gender) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender=gender;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public int getGender() { return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }


    // Override of the toString method

    @Override
    public String toString(){
        return "The id is : " + this.id + " , the name is : " + this.name + " , the email is : " + this.email + " , the surname is : " + this.surname+ " , the birthdate is : " + this.birthDate + " , the gender is : " + this.gender;
    }

    // MapIn and MapOut

    public int mapOut(PreparedStatement pPreparedStatement) throws SQLException {
        int lIterator = 1;
        pPreparedStatement.setString(lIterator++, this.name);
        pPreparedStatement.setString(lIterator++, this.email);
        pPreparedStatement.setString(lIterator++, this.surname);
        pPreparedStatement.setTimestamp(lIterator++, this.birthDate);
        pPreparedStatement.setInt(lIterator++, this.gender);
        return lIterator;
    }

    public static User mapIn(ResultSet pResultSet) throws SQLException {
        User lUser = new User();
        lUser.id = pResultSet.getInt("id");
        lUser.name = pResultSet.getString("name");
        lUser.email = pResultSet.getString("email");
        lUser.surname = pResultSet.getString("surname");
        lUser.birthDate = pResultSet.getTimestamp("birthDate");
        lUser.gender = pResultSet.getInt("gender");
        return lUser;
    }
}
