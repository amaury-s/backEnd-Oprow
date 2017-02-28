package com.oprow.controllers;

import com.oprow.bo.Ask;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.oprow.models.ServiceModel.*;
import static com.oprow.models.AskModel.*;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="name/{pIdService}", method = RequestMethod.GET)
    public static @ResponseBody String getServiceNameFromId(@PathVariable int pIdService) {

        try{
            return getServiceName(pIdService);
        }catch(Exception ex) {
            return null;
        }

    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/average/{pIdService}", method = RequestMethod.GET)
    public static @ResponseBody long getAverageAchievementTimeForAService(@PathVariable int pIdService){

        List<Ask> liskOfAsk;
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

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/average/{pIdService}/{pIdAdmin}", method = RequestMethod.GET)
    public static @ResponseBody long getAverageAchievementTimeForAService(@PathVariable int pIdService, @PathVariable int pIdAdmin){

        List<Ask> liskOfAsk;
        long totalTime = 0;
        long averageTime = 0;

        try{
            liskOfAsk = getAllAskByServiceAndAdmin(pIdService, pIdAdmin);

            for(Ask anAsk : liskOfAsk){
                totalTime += (anAsk.getDepartureTime().getTime() - anAsk.getEndWaitingTime().getTime());
            }

            averageTime = totalTime / liskOfAsk.size();

        }catch(Exception ex){

        }

        return averageTime;
    }

}