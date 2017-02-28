package com.oprow.bo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class Schedules {

    protected Time morningOpeningTime;
    protected Time morningClosingTime;
    protected Time afternoonOpeningTime;
    protected Time afternoonClosingTime;
    protected int dayOfTheWeek;
    protected int adminId;

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

    public int getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(int dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public static Schedules mapIn(ResultSet pResultSet) throws SQLException {
        Schedules lSchedules = new Schedules();

        lSchedules.morningOpeningTime = pResultSet.getTime("morningOpeningTime");
        lSchedules.morningClosingTime = pResultSet.getTime("morningClosingTime");
        lSchedules.afternoonOpeningTime = pResultSet.getTime("afternoonOpeningTime");
        lSchedules.afternoonClosingTime = pResultSet.getTime("afternoonClosingTime");
        lSchedules.dayOfTheWeek = pResultSet.getInt("dayOfTheWeek");
        lSchedules.adminId= pResultSet.getInt("adminId");

        return lSchedules;
    }

}
