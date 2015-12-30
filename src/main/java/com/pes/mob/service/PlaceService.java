package com.pes.mob.service;

import java.util.Collection;
import java.util.List;

import com.pes.mob.model.Place;
import com.pes.mob.model.Valoration;

public interface PlaceService {
	
	Place findById(String four_id);
    
    void savePlace(Place place);
     
    void updatePlace(Place place);
     
    List<Place> findAllPlaces(); 
    
    Collection<Valoration> findAllValorations(String id);
    
    boolean exists(String four_id);
    
    Place findByCoordinates(String ll);
    
    void updatePlace(String ll, String adaptedLevel);
    
}

