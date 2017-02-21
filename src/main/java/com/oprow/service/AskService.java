package com.oprow.service;


import com.oprow.bo.Need;
import org.springframework.web.bind.annotation.*;
import com.oprow.bo.User;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/asks")
public class AskService {

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Need> getUserInJSON() {

        List<Need> listOfNeed= new ArrayList<Need>();

        Need need = new Need();
        need.setAdminName("Mairie 15");
        need.setNeed("Passport");
        need.setDate(new Date(System.currentTimeMillis()));
        need.setTime(new Timestamp(System.currentTimeMillis()));

        listOfNeed.add(need);

        Need need2 = new Need();
        need2.setAdminName("Mairie 12");
        need2.setNeed("Manger");
        need2.setDate(new Date(System.currentTimeMillis()));
        need2.setTime(new Timestamp(System.currentTimeMillis()));

        listOfNeed.add(need2);

        return listOfNeed;

    }

}
