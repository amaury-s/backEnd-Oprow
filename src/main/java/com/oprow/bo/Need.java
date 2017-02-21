package com.oprow.bo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Baptiste on 15/02/2017.
 */
public class Need {

    protected String adminName;
    protected Date date;
    protected Timestamp time;
    protected String need;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }
}
