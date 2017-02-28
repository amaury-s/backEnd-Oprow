package com.oprow.controllers;

import com.oprow.bo.Ask;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.oprow.models.ServiceModel.*;
import static com.oprow.models.AskModel.*;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/{pIdService}", method = RequestMethod.GET)
    public static @ResponseBody String getServiceNameFromId(@PathVariable int pIdService) {

        try{
            return getServiceName(pIdService);
        }catch(Exception ex) {
            return null;
        }

    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/average/{pIdService}", method = RequestMethod.GET)
    public static @ResponseBody long getAchievementTimeForAService(@PathVariable int pIdService){

        List<Ask> liskOfAsk = new ArrayList<>();
        long totalTime = 0;
        long averageTime = 0;

        try{
            liskOfAsk = getAllAskForServiceId(pIdService);

            for(Ask anAsk : liskOfAsk){
                totalTime += (anAsk.getDepartureTime().getTime() - anAsk.getEndWaitingTime().getTime());
            }

            averageTime = totalTime / liskOfAsk.size();

        }catch(Exception ex){

        }

        return averageTime;
    }

}