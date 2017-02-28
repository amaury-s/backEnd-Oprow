package com.oprow.service;

import com.oprow.bo.Affluence;
import com.oprow.bo.Ask;
import com.oprow.models.AdministrationModel;
import org.springframework.web.bind.annotation.*;

import com.oprow.bo.Administration;

import java.sql.Date;
import java.sql.Time;
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


/*
    public static void main(String[] args){
        Timestamp arrivalTime = new Timestamp(System.currentTimeMillis());

        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(arrivalTime);

        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);

        Calendar cal2 = GregorianCalendar.getInstance();
        cal2.clear();
        cal2.set(Calendar.WEEK_OF_YEAR, week);
        cal2.set(Calendar.YEAR, year);
        cal2.set(Calendar.DAY_OF_WEEK, cal.get(Calendar.DAY_OF_WEEK));

        System.out.println(cal2.getTimeInMillis());


    }*/

}
