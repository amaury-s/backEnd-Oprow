package com.oprow.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {

    protected int serviceId;
    protected String serviceName;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public static Service mapIn(ResultSet pResultSet) throws SQLException {
        Service lService = new Service();

        lService.serviceName = pResultSet.getString("serviceName");
        lService.serviceId = pResultSet.getInt("serviceId");

        return lService;
    }

}
