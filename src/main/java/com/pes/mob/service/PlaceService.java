package com.pes.mob.service;

import java.util.List;

import com.pes.mob.model.Place;

public interface PlaceService {
	
	Place findById(String four_id);
    
    void savePlace(Place place);
     
    void updatePlace(Place place);
     
    List<Place> findAllPlaces(); 
     

}
