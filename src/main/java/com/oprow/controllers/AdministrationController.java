package com.oprow.controllers;

import org.springframework.web.bind.annotation.*;

import com.oprow.bo.Administration;

import java.util.ArrayList;
import java.util.List;

import static com.oprow.models.AdministrationModel.*;
import static com.oprow.controllers.SchedulesController.*;


@RestController
@RequestMapping("/admin")
public class AdministrationController {

    /**
     * GET / --> Return the list of all administrations
     */
    @RequestMapping(value="/list", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:8100")
    public @ResponseBody List<Administration> getAdminList() {

        List<Administration> listOfAdministration = new ArrayList<>();

        try{
            listOfAdministration = getAllAdministration();

            for(Administration anAdmin: listOfAdministration){
                anAdmin.setListOfSchedules(getListOfSchedulesForAnAdmin(anAdmin.getId()));
            }
        }catch(Exception ex) {
            return listOfAdministration;
        }

        return listOfAdministration;
    }

    /**
     * GET / --> Return the list of user favorite administrations
     */
    @RequestMapping(value="/list/{pIdUser}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:8100")
    public @ResponseBody List<Administration> getFavoriteAdminForUser(@PathVariable int pIdUser) {

        List<Administration> listOfAdministration = new ArrayList<>();

        try{
            listOfAdministration = getUserFavoriteAdministration(pIdUser);
            for(Administration anAdmin: listOfAdministration){
                anAdmin.setListOfSchedules(getListOfSchedulesForAnAdmin(anAdmin.getId()));
            }
        }catch(Exception ex) {
            return listOfAdministration;
        }

        return listOfAdministration;
    }

    /**
     * GET / --> Return informations about one administration from id
     */
    @RequestMapping(value="/{pIdAdmin}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:8100")
    public static @ResponseBody Administration getAdministrationFromId(@PathVariable int pIdAdmin) {
        try{
            return getAdministrationFroId(pIdAdmin);
        }catch(Exception ex) {
            return null;
        }

    }

    /**
     * POST / --> Add an administration to user's administration list
     */
    @RequestMapping(value="/add/{pIdUser}/{pIdAdmin}", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8100")
    public @ResponseBody String addAnAdministrationToUser(@PathVariable int pIdUser, @PathVariable int pIdAdmin) {

        try{
           insertFavoriteAdministrationForUser(pIdUser,pIdAdmin);
        }catch(Exception ex) {
            return "Administration cannot be added to the user list";
        }

        return "Administration added to the user list";

    }

    /**
     * POST / --> Delete an administration to user's administration list
     */
    @RequestMapping(value="/delete/{pIdUser}/{pIdAdmin}", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:8100")
    public @ResponseBody String deleteAnAdministrationToUser(@PathVariable int pIdUser, @PathVariable int pIdAdmin) {

        try{
            deleteFavoriteAdministrationForUser(pIdUser,pIdAdmin);
        }catch(Exception ex) {
            return "Administration cannot be deleted to the user list";
        }

        return "Administration deleted to the user list";

    }


}
