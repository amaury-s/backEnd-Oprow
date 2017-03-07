package com.oprow.models;

import com.oprow.bo.User;
import com.oprow.utils.TechniqueException;

public class UserModel extends Model{

    public static int insertUser(User pUser) throws TechniqueException {
        return update(
                "INSERT INTO users(name, email, surname,birthDate,gender)"
                        + "VALUES (?,?,?,?,?)",
                lPreparedStatement -> {
                    pUser.mapOut(lPreparedStatement);
                });
    }

    public static User getUserById(int pId) throws TechniqueException {
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
