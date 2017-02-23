package com.oprow.models;

import com.oprow.bo.User;
import com.oprow.utils.TechniqueException;

import java.sql.Statement;


public class UserModel extends Model{

    public int insertUser(User pUser) throws TechniqueException {
        return update(
                "INSERT INTO users(name, email)"
                        + "VALUES (?,?)",
                lPreparedStatement -> {
                    pUser.mapOut(lPreparedStatement);
                });
    }

    public User getUserFromId(int pId) throws TechniqueException {
        return select("SELECT * FROM users WHERE id = ?", lPreparedStatement -> {
            lPreparedStatement.setInt(1, pId);
        }, lResultSet -> {
            if (lResultSet.next()) {
                return User.mapIn(lResultSet);
            }
            throw new TechniqueException("User not found");
        });
    }

}
