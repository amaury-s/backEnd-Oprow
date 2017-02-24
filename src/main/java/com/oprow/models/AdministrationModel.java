package com.oprow.models;

import com.oprow.bo.Administration;
import com.oprow.utils.TechniqueException;

import java.util.ArrayList;
import java.util.List;

public class AdministrationModel extends Model{

    public static List<Administration> getAllAdministration() throws TechniqueException {
        return select("SELECT * FROM administrations WHERE TRUE", null, lResultSet -> {
            List<Administration> listOfAdministrations = new ArrayList<>();
            while(lResultSet.next()) {
                listOfAdministrations.add(Administration.mapIn(lResultSet));
            }
            return listOfAdministrations;
        });
    }

    public static List<Administration> getUserFavoriteAdministration(int pIdUser) throws TechniqueException {
        return select("SELECT * FROM administrations where id IN (select idAdministration from favoriteAdministration where idUser = ?)",
                lPreparedStatement -> {
                    lPreparedStatement.setInt(1, pIdUser);
                },
                lResultSet -> {
                    List<Administration> listOfAdministrations = new ArrayList<>();
                    while(lResultSet.next()) {
                        listOfAdministrations.add(Administration.mapIn(lResultSet));
                    }
                    return listOfAdministrations;
                }
        );
    }

    public static Administration getAdministrationFroId(int pIdAdmin) throws TechniqueException {
        return select("SELECT * FROM administrations WHERE id = ?", lPreparedStatement -> {
                lPreparedStatement.setInt(1, pIdAdmin);
            }, lResultSet -> {
                Administration admin = new Administration();
                while(lResultSet.next()) {
                    admin = Administration.mapIn(lResultSet);
                }
                return admin;
            }
        );
    }

    public static int insertAdministration(Administration pAdministration) throws TechniqueException {
        return update(
                "INSERT INTO administrations(morningOpeningTime, morningClosingTime, afternoonOpeningTime, " +
                        "afternoonClosingTime, name)"
                        + "VALUES (?,?,?,?,?)",
                lPreparedStatement -> {
                    pAdministration.mapOut(lPreparedStatement);
                });
    }

    public static int insertFavoriteAdministrationForUser(int pIdUser, int pIdAdmin) throws TechniqueException {
        return update(
                "INSERT INTO favoriteAdministration(idUser, idAdministration)"
                        + "VALUES (?,?)",
                lPreparedStatement -> {
                    int lIterator = 1;
                    lPreparedStatement.setInt(lIterator++, pIdUser);
                    lPreparedStatement.setInt(lIterator++, pIdAdmin);
                });
    }

}
