package com.oprow.controllers;

import com.oprow.bo.Ask;
import com.oprow.bo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.oprow.models.AskModel.getAskForUser;
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
    /**
     * GET / --> Return the list of ask for a specific user
     */
    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/{pIdUser}", method = RequestMethod.GET)
    public @ResponseBody
    User getUserInJSON(@PathVariable int pIdUser) {
        try{
            return getUserById(pIdUser);
        }catch(Exception ex) {
            return null;
        }

    }

}
