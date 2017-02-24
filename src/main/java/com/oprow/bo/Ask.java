package com.oprow.bo;

import java.sql.*;

public class Ask {

    protected int adminId;
    protected int userId;
    protected String type;
    protected Time arrivalTime;
    protected Time departureTime;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public int mapOut(PreparedStatement pPreparedStatement) throws SQLException {
        int lIterator = 1;
        pPreparedStatement.setInt(lIterator++, this.adminId);
        pPreparedStatement.setInt(lIterator++, this.userId);
        pPreparedStatement.setString(lIterator++, this.type);
        pPreparedStatement.setTime(lIterator++, this.arrivalTime);
        pPreparedStatement.setTime(lIterator++, this.departureTime);
        return lIterator;
    }

    public static Ask mapIn(ResultSet pResultSet) throws SQLException {
        Ask lAsk = new Ask();
        lAsk.adminId = pResultSet.getInt("adminId");
        lAsk.userId= pResultSet.getInt("userId");
        lAsk.type = pResultSet.getString("type");
        lAsk.arrivalTime = pResultSet.getTime("arrivalTime");
        lAsk.departureTime = pResultSet.getTime("departureTime");

        return lAsk;
    }
}
