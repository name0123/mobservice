package com.pes.mob.dao;

import java.util.List;


import com.pes.mob.model.*;


public interface PlaceDao {
	
    Place findById(String four_id);
    
    void savePlace(Place place);
     
    List<Place> findAllPlaces();

}
