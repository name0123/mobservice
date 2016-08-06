package com.pes.mob.service;

import java.util.List;

import com.pes.mob.model.Place;
import com.pes.mob.model.User;
import com.pes.mob.model.Valoration;

public interface ValorationService {
	 
	Valoration findById(String valoration_id);
	
	Valoration findByCoordinates(String ll);
	List<Valoration> findByFourId(String ll);
     
    void saveValoration(Valoration valor);
    
    void saveValoration(Valoration valor, User u, Place f);
     
    void updateValoration(Valoration valor);
     
   List<Valoration> findAllValorations();
     
}
