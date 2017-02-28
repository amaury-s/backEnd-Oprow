package com.oprow.service;

import com.oprow.bo.Ask;
import com.oprow.bo.Schedules;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.oprow.models.SchedulesModel.*;
import static com.oprow.models.ServiceModel.*;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value="/{pIdAdmin}", method = RequestMethod.GET)
    public static @ResponseBody String getServiceNameFromId(@PathVariable int pIdService) {

        try{
            return getServiceName(pIdService);
        }catch(Exception ex) {
            return null;
        }

    }

}