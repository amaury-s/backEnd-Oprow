package com.oprow.service;


import com.oprow.bo.Administration;
import com.oprow.bo.Ask;
import com.oprow.models.AdministrationModel;
import com.oprow.models.AskModel;
import com.oprow.utils.TechniqueException;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.oprow.models.AskModel.*;

@RestController
@RequestMapping("/asks")
public class AskController {

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public @ResponseBody List<Ask> getUserInJSON() {

        List<Ask> listOfAsk = new ArrayList<Ask>();

        try{
            listOfAsk = getAllAsk();
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

        try{
            insertAskForUser(pAsk);
        }catch(Exception ex) {
            return "Ask cannot be added for this user";
        }

        return "Ask added for this user";

    }

}
