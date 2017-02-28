package com.oprow.bo;

import java.sql.*;

public class Ask {

    protected int adminId;
    protected String adminName;
    protected int userId;
    protected String userName;
    protected int serviceId;
    protected String serviceName;
    protected Timestamp arrivalTime;
    protected Timestamp endWaitingTime;
    protected Timestamp departureTime;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public Timestamp getEndWaitingTime() {
        return endWaitingTime;
    }

    public void setEndWaitingTime(Timestamp endWaitingTime) {
        this.endWaitingTime = endWaitingTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public int mapOut(PreparedStatement pPreparedStatement) throws SQLException {
        int lIterator = 1;
        pPreparedStatement.setInt(lIterator++, this.adminId);
        pPreparedStatement.setInt(lIterator++, this.userId);
        pPreparedStatement.setInt(lIterator++, this.serviceId);
        pPreparedStatement.setTimestamp(lIterator++, this.arrivalTime);
        pPreparedStatement.setTimestamp(lIterator++, this.endWaitingTime);
        pPreparedStatement.setTimestamp(lIterator++, this.departureTime);
        return lIterator;
    }

    public static Ask mapIn(ResultSet pResultSet) throws SQLException {
        Ask lAsk = new Ask();
        lAsk.adminId = pResultSet.getInt("adminId");
        lAsk.userId= pResultSet.getInt("userId");
        lAsk.serviceId = pResultSet.getInt("serviceId");
        lAsk.arrivalTime = pResultSet.getTimestamp("arrivalTime");
        lAsk.endWaitingTime = pResultSet.getTimestamp("endWaitingTime");
        lAsk.departureTime = pResultSet.getTimestamp("departureTime");

        return lAsk;
    }
}
