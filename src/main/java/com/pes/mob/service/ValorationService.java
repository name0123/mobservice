package com.pes.mob.service;

import java.util.List;

import com.pes.mob.model.Valoration;

public interface ValorationService {
	 
	Valoration findById(String valoration_id);
     
    void saveValoration(Valoration valor);
     
    void updateValoration(Valoration valor);
     
   List<Valoration> findAllValorations();
     
}
