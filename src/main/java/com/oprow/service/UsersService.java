package com.oprow.service;

import org.springframework.web.bind.annotation.*;
import com.oprow.bo.User;

@RestController
public class UsersService {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public @ResponseBody User getUserInJSON() {

        User user = new User();
        user.setmEmail("test@test.fr");
        user.setmFirstName("Test");

        return user;

    }

}
