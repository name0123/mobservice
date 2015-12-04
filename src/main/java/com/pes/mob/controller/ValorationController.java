package com.pes.mob.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pes.mob.model.Valoration;
import com.pes.mob.service.ValorationService;

@RestController
@RequestMapping(value="/valorations", headers = "Accept=application/json")
public class ValorationController {
    @Autowired 
    ValorationService valorationService;
	
	
    @RequestMapping(value = { "/getall" }, method = RequestMethod.GET)
    public  @ResponseBody List<Valoration> getAllValorations() {
       
    	return valorationService.findAllValorations();
       
       
    }
    
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public ResponseEntity<Valoration> saveValoration(@RequestBody Valoration valor) { 
    	valorationService.saveValoration(valor);
        return new ResponseEntity<Valoration>(valor,HttpStatus.OK);

    }
	
}
