package com.oprow.service;

import com.oprow.bo.User;
import com.oprow.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserModel mUserModel = new UserModel();

    /**
     * GET / --> Create a new user and save it in the database.
     */
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    String getShopInJSON(@RequestBody User user) {

        System.out.println(user);

        int userId;
        try{

            mUserModel.insertUser(user);

        }catch(Exception ex) {
            return "Error creating the user: " + ex.toString();
        }

        return "User succesfully created";

    }

}
