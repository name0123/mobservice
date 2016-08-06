package com.pes.mob.dao;



import java.util.List;

import com.pes.mob.model.Place;
import com.pes.mob.model.User;
import com.pes.mob.model.Valoration;


public interface ValorationDao {
	
    Valoration findById(String valoration_id);
    
    void saveValoration(Valoration valor);
    void saveValoration(Valoration valor, User u, Place f);
    
    List<Valoration> findAllValorations();
    // this is not ok done buz who did it!
    Valoration findByCoordinates(String latitude, String longitude);
    
    // this is ok
    List<Valoration> findByFourId(String four_id);
}

