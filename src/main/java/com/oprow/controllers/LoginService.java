package com.oprow.controllers;

import com.oprow.bo.Token;
import com.oprow.bo.User;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
public class LoginService {

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8100")
    public @ResponseBody Token getShopInJSON(@RequestBody User user) {

        Token aToken = new Token();
        aToken.setToken("IJFNJNJKEJHIDJKSJBFHSKFS");

        System.out.println(user);

        return aToken;

    }

}
