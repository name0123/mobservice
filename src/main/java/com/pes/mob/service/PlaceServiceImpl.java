/**
 * 	PLACESERVICEIMPL
 * 
 * 
 * 
 */
package com.pes.mob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pes.mob.dao.PlaceDao;
import com.pes.mob.model.Place;

@Service("placeService")
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDao dao;
     
    public Place findById(String four_id) {
        return dao.findById(four_id);
    }
 
    public void savePlace(Place place) {
        dao.savePlace(place);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updatePlace(Place place) {
    	Place entity = dao.findById(place.getFour_id());
        if(entity!=null){
            entity.setName(place.getName());
            // set longitude, latitude .. etc
        }
    }
     
    public List<Place> findAllPlaces() {
        return dao.findAllPlaces();
    }
 
 
}
