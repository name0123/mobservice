package com.pes.mob.dao;

import java.util.Set;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.pes.mob.model.Valoration;

@Repository("valorationDao")

public class ValorationDaoImpl extends AbstractDao<String, Valoration> implements ValorationDao {

	
    public Valoration findById(String valoration_id) {
        return getByKey(valoration_id);
    }
 
    public void saveValoration(Valoration valor) {
        persist(valor);
    }
    
    @SuppressWarnings("unchecked")
    public Set<Valoration> findAllValorations(){
    	Criteria criteria = createEntityCriteria();
        return (Set<Valoration>) criteria.list();

    }
 

}
