/**
 * 	PLACESERVICEIMPL
 * 
 * 
 * 
 */
package com.pes.mob.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pes.mob.dao.PlaceDao;
import com.pes.mob.model.Place;
import com.pes.mob.model.Valoration;

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
        if(entity!=null) {
            entity.setAdaptedLevel(place.getAdaptedLevel());
        }
    }
     
    public List<Place> findAllPlaces() {
        return dao.findAllPlaces();
    }

	@Override
	public boolean exists(String four_id) {
		return this.findById(four_id) != null;
	}

	@Override
	public Place findByCoordinates(String ll) {
		String[] latlong = ll.split(",");
		return dao.findByCoordinates(latlong[0], latlong[1]);
	}

	@Override
	public void updatePlace(String ll, String adaptedLevel) {
		String[] latlong = ll.split(",");
		Place place = dao.findByCoordinates(latlong[0], latlong[1]);
		//afegir valoració i recalcular adaptedLevel
		//actualitzar place si és necessari
		this.updatePlace(place);
	}

	@Override
	public Collection<Valoration> findAllValorations(String id) {
		// TODO Auto-generated method stub
		Collection<Valoration> allVal = dao.findAllValorations(id);
		return allVal;
	}
 
 
}
