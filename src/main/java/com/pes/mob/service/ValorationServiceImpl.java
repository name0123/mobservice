/**
 * 
 * USER SERVICE! ;)
 * Authors and company
 * 
 * 
 */
package com.pes.mob.service;


import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pes.mob.dao.ValorationDao;
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
    public Set<Valoration> findAllValorations(){
    	return dao.findAllValorations();
    }


}
