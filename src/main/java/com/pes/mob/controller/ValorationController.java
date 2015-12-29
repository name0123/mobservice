package com.pes.mob.controller;

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
import com.pes.mob.model.User;
import com.pes.mob.model.Valoration;
import com.pes.mob.service.PlaceService;
import com.pes.mob.service.UserService;
import com.pes.mob.service.ValorationService;

@RestController
@RequestMapping(value="/valorations", headers = "Accept=application/json")
public class ValorationController {
    @Autowired 
    ValorationService valorationService;
    @Autowired
    UserService userService;
    @Autowired
    PlaceService placeService;
	
	
    @RequestMapping(value = { "/getall" }, method = RequestMethod.GET)
    public  @ResponseBody List<Valoration> getAllValorations() {
    	return valorationService.findAllValorations();      
       
    }
    
    @RequestMapping(value = { "/get" }, method = RequestMethod.GET)
    public Valoration getValoration(@RequestParam (value="ll", defaultValue="") String ll){
       return valorationService.findByCoordinates(ll);
       
    }   

    
    
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Valoration> saveValoration(@RequestBody Valoration valor) {
    	System.err.println("Foooc:>>>>>>>>>>>>>>>>>>>>>" + valor.toString());
    	
    	User u = userService.findById(valor.getUser_id());

    	Place p =  	placeService.findById(valor.getFour_id());
    	
    	valorationService.saveValoration(valor, u, p );

    	return new ResponseEntity<Valoration>(valor,HttpStatus.OK);

    }

}
