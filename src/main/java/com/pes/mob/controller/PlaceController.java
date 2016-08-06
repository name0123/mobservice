package com.pes.mob.controller;



import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pes.mob.model.Place;
import com.pes.mob.model.Valoration;
import com.pes.mob.service.PlaceService;

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
    
    @RequestMapping(value = { "/getcs" }, method = RequestMethod.GET)
    public Place getPlace(@RequestParam (value="ll", defaultValue="") String ll){
       return placeService.findByCoordinates(ll);
       
    }
    @RequestMapping(value = { "/getfour" }, method = RequestMethod.GET)
    public Place getPlaceId(@RequestParam (value="id") String id){
       return placeService.findById(id);
       
    }
    
    /**
     * 
     * All valorations of a place
     * @param id
     * @return
     */
    @RequestMapping(value = { "/valorations" }, method = RequestMethod.GET)
    public  Collection<Valoration> getAllValorations(@RequestParam (value="four_id")String id) {
       return placeService.findAllValorations(id);
       
    }
    
    
    @RequestMapping(value = { "/update" }, method = RequestMethod.PUT)
    public void updatePlace(@RequestParam(value="ll", defaultValue="") String ll,
    												@RequestParam(value="al", defaultValue="unknown") String al) { 
        placeService.updatePlace(ll, al);
    }
	
}
