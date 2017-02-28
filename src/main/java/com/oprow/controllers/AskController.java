package com.oprow.controllers;


import com.oprow.bo.Ask;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static com.oprow.models.AskModel.*;
import static com.oprow.controllers.AdministrationController.*;
import static com.oprow.controllers.ServiceController.*;


@RestController
@RequestMapping("/asks")
public class AskController {

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public @ResponseBody List<Ask> getUserInJSON() {

        List<Ask> listOfAsk = new ArrayList<Ask>();

        try{
            listOfAsk = getAllAsk();
            for(Ask anAsk: listOfAsk){
                anAsk.setAdminName(getAdministrationFromId(anAsk.getAdminId()).getName());
                anAsk.setServiceName(getServiceNameFromId(anAsk.getServiceId()));
            }
        }catch(Exception ex) {
            return listOfAsk;
        }

        return listOfAsk;

    }

    /**
     * GET / --> Return the list of ask for a specific user
     */
    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/list/{pIdUser}", method = RequestMethod.GET)
    public @ResponseBody List<Ask> getUserInJSON(@PathVariable int pIdUser) {

        List<Ask> listOfAsk = new ArrayList<Ask>();

        try{
            listOfAsk = getAskForUser(pIdUser);
        }catch(Exception ex) {
            return listOfAsk;
        }

        return listOfAsk;

    }

    /**
     * POST / --> Add and ask for a specific user
     */
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public @ResponseBody String addAnAskToUser(@RequestBody Ask pAsk) {

        Calendar cal = GregorianCalendar.getInstance();
        cal.setTimeInMillis(pAsk.getArrivalTime().getTime());
        pAsk.setDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));

        try{
            insertAskForUser(pAsk);
        }catch(Exception ex) {
            return "Ask cannot be added for this user";
        }

        return "Ask added for this user";

    }

}
