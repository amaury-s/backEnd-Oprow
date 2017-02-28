package com.oprow.controllers;

import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static com.oprow.models.AskModel.*;


@RestController
@RequestMapping("/affluence")
public class AffluenceController {


    @RequestMapping(method = RequestMethod.GET, value="/day/{pIdAdmin}/{pArrivalTime}")
    @CrossOrigin(origins = "http://localhost:8100")
    public @ResponseBody List<Integer> getAffluenceForAdminAndDay(@PathVariable int pIdAdmin, @PathVariable long pArrivalTime) {

        final long duration = 60 * 60 * 1000;

        Calendar cal = GregorianCalendar.getInstance();
        cal.setTimeInMillis(pArrivalTime);
        cal.set(Calendar.HOUR_OF_DAY, 7);
        Timestamp arrivalTime = new Timestamp(cal.getTimeInMillis());
        Timestamp depatureTime = new Timestamp(arrivalTime.getTime());
        depatureTime.setTime(depatureTime.getTime() + duration);

        List<Integer> listOfNumberOfAsk = new ArrayList<>();

        try{
            for(int i = 0; i<10; i++){

                System.out.println(arrivalTime);
                System.out.println(depatureTime);

                listOfNumberOfAsk.add(getNumberOfAskForAPeriod(
                        pIdAdmin,
                        arrivalTime,
                        depatureTime
                ));

                arrivalTime.setTime(arrivalTime.getTime() + duration);
                depatureTime.setTime(depatureTime.getTime() + duration);
            }

        }catch(Exception ex){
            return null;
        }

        return listOfNumberOfAsk;

    }

}
