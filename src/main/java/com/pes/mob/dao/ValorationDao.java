package com.pes.mob.dao;



import java.util.Set;

import com.pes.mob.model.Valoration;


public interface ValorationDao {
	
    Valoration findById(String valoration_id);
    
    void saveValoration(Valoration valor);
    
    Set<Valoration> findAllValorations();
 
}

