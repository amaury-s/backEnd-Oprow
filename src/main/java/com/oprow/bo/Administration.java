package com.oprow.bo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Administration {

    protected int id;
    protected String name;
    protected List<Schedules> listOfSchedules;
    protected List<Service> listOfServices;

    public List<Service> getListOfServices() {
        return listOfServices;
    }

    public void setListOfServices(List<Service> listOfServices) {
        this.listOfServices.addAll(listOfServices);
    }

    public List<Schedules> getListOfSchedules() {
        return listOfSchedules;
    }

    public void setListOfSchedules(List<Schedules> listOfSchedules) {
        this.listOfSchedules = listOfSchedules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int mapOut(PreparedStatement pPreparedStatement) throws SQLException {
        int lIterator = 1;
        pPreparedStatement.setInt(lIterator++, this.id);
        pPreparedStatement.setString(lIterator++, this.name);
        return lIterator;
    }

    public static Administration mapIn(ResultSet pResultSet) throws SQLException {
        Administration lAdministration = new Administration();

        lAdministration.listOfServices = new ArrayList<Service>();
        lAdministration.listOfSchedules = new ArrayList<>();

        lAdministration.id = pResultSet.getInt("id");
        lAdministration.name = pResultSet.getString("name");

        return lAdministration;
    }

}
