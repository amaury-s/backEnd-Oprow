package com.oprow.service;

import com.oprow.bo.Token;
import com.oprow.bo.User;
import org.springframework.web.bind.annotation.*;

import com.oprow.bo.Administration;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminService {

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public @ResponseBody List<Administration> getAdminListInJSON() {

        List<Administration> listOfAdministration = new ArrayList<>();

        Administration admin = new Administration();
        admin.setId(1);
        admin.setName("Mairie 15");
        admin.setEstimatedWaitingTime(12);
        admin.setClosingTime(new Date(System.currentTimeMillis()));
        admin.setOpeningTime(new Date(System.currentTimeMillis()));
        admin.generateRandomValues();

        Administration admin2 = new Administration();
        admin2.setId(2);
        admin2.setName("Mairie 12");
        admin2.setEstimatedWaitingTime(20);
        admin2.setClosingTime(new Date(System.currentTimeMillis()));
        admin2.setOpeningTime(new Date(System.currentTimeMillis()));
        admin2.generateRandomValues();

        listOfAdministration.add(admin);
        listOfAdministration.add(admin2);

        return listOfAdministration;

    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody Administration addAdminToUser(@PathVariable int id){

        Administration admin2 = new Administration();
        admin2.setId(id);
        admin2.setName("Mairie 12");
        admin2.setEstimatedWaitingTime(20);
        admin2.setClosingTime(new Date(System.currentTimeMillis()));
        admin2.setOpeningTime(new Date(System.currentTimeMillis()));
        admin2.generateRandomValues();

        return admin2;

    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/add/{id}", method = RequestMethod.GET)
    public @ResponseBody String addAdminToUser(@PathVariable String id){
        return id;

    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/del/{id}", method = RequestMethod.GET)
    public @ResponseBody String delAdminToUser(@PathVariable String id){
        return id;
    }


}
