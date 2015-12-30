package com.pes.mob.dao;

import java.util.Collection;
import java.util.List;

import com.pes.mob.model.Place;
import com.pes.mob.model.Valoration;


public interface PlaceDao {
	
    Place findById(String four_id);
    
    void savePlace(Place place);
     
    List<Place> findAllPlaces();

	Place findByCoordinates(String latitude, String longitude);

	Collection<Valoration> findAllValorations(String id);

}
