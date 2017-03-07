package com.oprow.controllers;

import com.oprow.bo.User;
import org.springframework.web.bind.annotation.*;

import static com.oprow.models.UserModel.*;

@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * POST / --> Create a new user and save it in the database.
     */
    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8100")
    public @ResponseBody
    String getShopInJSON(@RequestBody User user) {

        System.out.println(user);

        int userId;
        try{

            insertUser(user);

        }catch(Exception ex) {
            return "Error creating the user: " + ex.toString();
        }

        return "User succesfully created";

    }

}
