package com.pes.mob.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pes.mob.model.Place;
import com.pes.mob.model.Valoration;

@Repository("placeDao")
public class PlaceDaoImpl extends AbstractDao<String, Place> implements PlaceDao {

    public Place findById(String four_id) {
        return getByKey(four_id);
    }
 
    public void savePlace(Place place) {
        persist(place);
    }
 
    @SuppressWarnings("unchecked")
    public List<Place> findAllPlaces() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Place>) criteria.list();
    }
    
	@Override
	public Place findByCoordinates(String latitude, String longitude) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("latitude", Double.parseDouble(latitude)));
        criteria.add(Restrictions.eq("longitude", Double.parseDouble(longitude)));
        return (Place) criteria.uniqueResult();
	}

	@Override
	public Collection<Valoration> findAllValorations(String id) {
		// TODO Auto-generated method stub
		Place p = findById(id);
		return p.getPlaceValorations();
	}
}
