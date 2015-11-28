package com.pes.mob.controller;



import java.util.List;

import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pes.mob.model.Place;
import com.pes.mob.model.User;
import com.pes.mob.service.PlaceService;
import com.pes.mob.service.UserService;

@RestController
@RequestMapping(value="/places", headers = "Accept=application/json")
public class PlaceController {
    @Autowired 
    PlaceService placeService;
	
	
    @RequestMapping(value = { "/getall" }, method = RequestMethod.GET)
    public  @ResponseBody List<Place> getAllPlaces() {
       return placeService.findAllPlaces();
       
    }
    
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public ResponseEntity<Place> savePlace(@RequestBody Place place) { 
        placeService.savePlace(place);
        return new ResponseEntity<Place>(place,HttpStatus.OK);

    }
	
}
