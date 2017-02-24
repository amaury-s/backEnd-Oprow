package com.oprow.models;

import com.oprow.bo.Administration;
import com.oprow.bo.Ask;
import com.oprow.utils.TechniqueException;

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

    public static int insertAskForUser(Ask pAsk) throws TechniqueException{
        return update(
                "INSERT INTO asks(adminId, userId, type, arrivalTime, departureTime)"
                        + "VALUES (?,?,?,?,?)",
                lPreparedStatement -> {
                    pAsk.mapOut(lPreparedStatement);
                });
    }


}
