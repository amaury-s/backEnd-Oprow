package com.oprow.models;


import com.oprow.bo.Schedules;
import com.oprow.utils.TechniqueException;

import java.util.ArrayList;
import java.util.List;

public class SchedulesModel extends Model{

    public static List<Schedules> getSchedulesForAnAdmin(int pAdminId) throws TechniqueException {
        return select("SELECT * FROM schedules WHERE adminId = ?", lPreparedStatement -> {
            lPreparedStatement.setInt(1, pAdminId);
        }, lResultSet -> {
            List<Schedules> listOfSchedules = new ArrayList<>();
            while (lResultSet.next()) {
                listOfSchedules.add(Schedules.mapIn(lResultSet));
            }
            return listOfSchedules;
        });
    }

}
