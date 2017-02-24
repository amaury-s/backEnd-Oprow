package com.oprow.bo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Administration {

    protected int id;
    protected Time morningOpeningTime;
    protected Time morningClosingTime;
    protected Time afternoonOpeningTime;
    protected Time afternoonClosingTime;
    protected String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getMorningOpeningTime() {
        return morningOpeningTime;
    }

    public void setMorningOpeningTime(Time morningOpeningTime) {
        this.morningOpeningTime = morningOpeningTime;
    }

    public Time getMorningClosingTime() {
        return morningClosingTime;
    }

    public void setMorningClosingTime(Time morningClosingTime) {
        this.morningClosingTime = morningClosingTime;
    }

    public Time getAfternoonOpeningTime() {
        return afternoonOpeningTime;
    }

    public void setAfternoonOpeningTime(Time afternoonOpeningTime) {
        this.afternoonOpeningTime = afternoonOpeningTime;
    }

    public Time getAfternoonClosingTime() {
        return afternoonClosingTime;
    }

    public void setAfternoonClosingTime(Time afternoonClosingTime) {
        this.afternoonClosingTime = afternoonClosingTime;
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
        pPreparedStatement.setTime(lIterator++, this.morningClosingTime);
        pPreparedStatement.setTime(lIterator++, this.morningOpeningTime);
        pPreparedStatement.setTime(lIterator++, this.afternoonClosingTime);
        pPreparedStatement.setTime(lIterator++, this.afternoonOpeningTime);
        pPreparedStatement.setString(lIterator++, this.name);
        return lIterator;
    }

    public static Administration mapIn(ResultSet pResultSet) throws SQLException {
        Administration lAdministration = new Administration();

        lAdministration.id = pResultSet.getInt("id");
        lAdministration.morningClosingTime = pResultSet.getTime("morningClosingTime");
        lAdministration.morningOpeningTime = pResultSet.getTime("morningOpeningTime");
        lAdministration.afternoonClosingTime = pResultSet.getTime("afternoonClosingTime");
        lAdministration.afternoonOpeningTime = pResultSet.getTime("afternoonOpeningTime");
        lAdministration.name = pResultSet.getString("name");

        return lAdministration;
    }
}
