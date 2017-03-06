package com.oprow.models;


import com.oprow.bo.Service;
import com.oprow.bo.Schedules;
import com.oprow.utils.TechniqueException;

import java.util.ArrayList;
import java.util.List;

public class ServiceModel extends Model{

    public static String getServiceName(int pServiceId) throws TechniqueException {
        return select("SELECT * FROM services WHERE serviceId = ?", lPreparedStatement -> {
            lPreparedStatement.setInt(1, pServiceId);
        }, lResultSet -> {
            if (lResultSet.next()) {
                return lResultSet.getString("serviceName");
            }
            return null;
        });
    }
    public static List<Service> getAllServicesByAdmin(int pIdAdmin) throws TechniqueException {
        return select("SELECT * FROM servicesByAdministration NATURAL JOIN services WHERE adminId = ?",
                lPreparedStatement -> {
                    lPreparedStatement.setInt(1, pIdAdmin);
                },
                lResultSet -> {
                    List<Service> listOfServices = new ArrayList<>();
                    while(lResultSet.next()) {
                        listOfServices.add(Service.mapIn(lResultSet));
                    }
                    return listOfServices;
                });
    }

}