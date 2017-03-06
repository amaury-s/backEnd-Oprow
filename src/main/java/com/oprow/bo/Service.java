package com.oprow.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Amaury on 06/03/2017.
 */
public class Service {

    protected int serviceId;
    protected String serviceName;

    public static Service mapIn(ResultSet pResultSet) throws SQLException {
        Service lService = new Service();

        lService.serviceName = pResultSet.getString("serviceName");
        lService.serviceId = pResultSet.getInt("serviceId");

        return lService;
    }

}
