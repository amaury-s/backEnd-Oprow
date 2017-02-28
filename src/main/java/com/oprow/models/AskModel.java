package com.oprow.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oprow.bo.Ask;
import com.oprow.utils.TechniqueException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AskModel extends Model{

    public static List<Ask> getAllAsk() throws TechniqueException {
        return select("SELECT * FROM asks WHERE TRUE", null, lResultSet -> {
            List<Ask> listOfAsks = new ArrayList<>();
            while(lResultSet.next()) {
                listOfAsks.add(Ask.mapIn(lResultSet));
            }
            return listOfAsks;
        });
    }

    public static List<Ask> getAskForUser(int pIdUser) throws TechniqueException {
        return select("SELECT * FROM asks WHERE userId = ?",
                lPreparedStatement -> {
                    lPreparedStatement.setInt(1, pIdUser);
                },
                lResultSet -> {
                    List<Ask> listOfAsks = new ArrayList<>();
                    while(lResultSet.next()) {
                        listOfAsks.add(Ask.mapIn(lResultSet));
                    }
            return listOfAsks;
        });
    }

    public static int getNumberOfAskForAPeriod(int pIdAdmin, Timestamp pArrivalTime, Timestamp pDepartureTime) throws TechniqueException {
        return select("SELECT count(*) AS askcount FROM asks WHERE adminid = ? AND arrivalTime >= ? AND arrivalTime < ?",
                lPreparedStatement -> {
                    lPreparedStatement.setInt(1, pIdAdmin);
                    lPreparedStatement.setTimestamp(2, pArrivalTime);
                    lPreparedStatement.setTimestamp(3, pDepartureTime);
                },
                lResultSet -> {
                    lResultSet.next();
                    return lResultSet.getInt("askcount");
                });
    }

    public static int insertAskForUser(Ask pAsk) throws TechniqueException{
        return update(
                "INSERT INTO asks(adminId, userId, type, arrivalTime, departureTime)"
                        + "VALUES (?,?,?,?,?)",
                lPreparedStatement -> {
                    pAsk.mapOut(lPreparedStatement);
                });
    }

    public static List<Ask> getAllAskForServiceId(int pIdService) throws TechniqueException {
        return select("SELECT * FROM asks WHERE serviceId = ?",
                lPreparedStatement -> {
                    lPreparedStatement.setInt(1, pIdService);
                },
                lResultSet -> {
                    List<Ask> listOfAsk = new ArrayList<>();
                    while (lResultSet.next()) {
                        listOfAsk.add(Ask.mapIn(lResultSet));
                    }
                    return listOfAsk;
                }
                );
    }

}
