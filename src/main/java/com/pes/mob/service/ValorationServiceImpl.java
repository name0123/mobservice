/**
 * 
 * USER SERVICE! ;)
 * Authors and company
 * 
 * 
 */
package com.pes.mob.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pes.mob.dao.ValorationDao;
import com.pes.mob.model.Place;
import com.pes.mob.model.User;
import com.pes.mob.model.Valoration;

@Service("valorationService")
@Transactional
public class ValorationServiceImpl implements ValorationService {
  
	@Autowired
    private ValorationDao dao;
     
    public Valoration findById(String valoration_id) {
        return dao.findById(valoration_id);
    }
 
    public void saveValoration(Valoration valor) {
        dao.saveValoration(valor);
    }

    public void updateValoration(Valoration valor) {
    	String valoration_id = valor.getValoration_id();
    	Valoration entity = dao.findById(valoration_id);
        if(entity!=null){        }
    }
    public List<Valoration> findAllValorations(){
    	return dao.findAllValorations();
    }
    
    @Override
	public Valoration findByCoordinates(String ll) {
		String[] latlong = ll.split(",");
		return dao.findByCoordinates(latlong[0], latlong[1]);
	}
    
    @Override
   	public List<Valoration> findByFourId(String four_id) {
   		return dao.findByFourId(four_id);
   	}
	@Override
	public void saveValoration(Valoration valor, User u, Place f) {
		// TODO Auto-generated method stub
		// I need to check this out!
		 dao.saveValoration(valor, u, f);
	}
}
