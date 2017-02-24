package com.oprow.service;

import com.oprow.models.AdministrationModel;
import org.springframework.web.bind.annotation.*;

import com.oprow.bo.Administration;

import java.util.ArrayList;
import java.util.List;

import static com.oprow.models.AdministrationModel.*;


@RestController
@RequestMapping("/admin")
public class AdministrationController {

    /**
     * GET / --> Return the list of all administrations
     */
    @RequestMapping(value="/list", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:8100")
    public @ResponseBody List<Administration> getAdminListInJSON() {

        List<Administration> listOfAdministration = new ArrayList<>();

        try{
            listOfAdministration = getAllAdministration();
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
    public @ResponseBody List<Administration> getFavoriteAdminForUserInJSON(@PathVariable int pIdUser) {

        List<Administration> listOfAdministration = new ArrayList<>();

        try{
            listOfAdministration = getUserFavoriteAdministration(pIdUser);
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
    public @ResponseBody Administration getAdministrationInJSON(@PathVariable int pIdAdmin) {
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


}
