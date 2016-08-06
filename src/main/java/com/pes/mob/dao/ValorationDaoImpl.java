package com.pes.mob.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pes.mob.model.Place;
import com.pes.mob.model.User;
import com.pes.mob.model.Valoration;

@Repository("valorationDao")
public class ValorationDaoImpl extends AbstractDao<String, Valoration> implements ValorationDao {

	
    public Valoration findById(String valoration_id) {
        return getByKey(valoration_id);
    }
 
    public void saveValoration(Valoration valor) {
        // not real usage!
    	persist(valor);
    }
    
    @SuppressWarnings("unchecked")
    public List<Valoration> findAllValorations(){
    	Criteria criteria = createEntityCriteria();
        return (List<Valoration>) criteria.list();

    }
 
    @Override
	public Valoration findByCoordinates(String latitude, String longitude) {
    	// impossible - you weren't thinking when you did this: 
    	// restrictions are for the place!
		Criteria criteria = createEntityCriteria();
		
        criteria.add(Restrictions.eq("latitude", Double.parseDouble(latitude)));
        criteria.add(Restrictions.eq("longitude", Double.parseDouble(longitude)));
        return (Valoration) criteria.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Valoration> findByFourId(String four_id) {
		// 
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("four_id", four_id));
        List<Valoration> moreVals = (List<Valoration>) criteria.list();
        return (List<Valoration>) moreVals;
		
	}

	@Override
	public void saveValoration(Valoration valor, User user, Place f) {
		valor.setPlace(f);
		valor.setUser(user);
		persist(valor);
		
		
	}



}
