package com.oprow.controllers;

import com.oprow.bo.Schedules;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.oprow.models.SchedulesModel.*;

@RestController
@RequestMapping("/schedules")
public class SchedulesController {

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/list/{pIdAdmin}", method = RequestMethod.GET)
    public static @ResponseBody List<Schedules> getListOfSchedulesForAnAdmin(@PathVariable int pIdAdmin) {

        List<Schedules> listOfSchedules = new ArrayList<>();

        try{
            listOfSchedules = getSchedulesForAnAdmin(pIdAdmin);
        }catch(Exception ex) {
            return listOfSchedules;
        }

        return listOfSchedules;

    }

}
