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

import com.pes.mob.dao.UserDao;
import com.pes.mob.model.User;
import com.pes.mob.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
  
	@Autowired
    private UserDao dao;
     
    public User findById(String user_id) {
        return dao.findById(user_id);
    }
 
    public void saveUser(User User) {
        dao.saveUser(User);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateUser(User user) {
        User entity = dao.findById(user.getUser_id());
        if(entity!=null){
//            entity.setName(user.setId(33); 
//            entity.setJoiningDate(user.getJoiningDate());
//            entity.setSalary(user.getSalary());
//            entity.setSsn(user.getSsn());
        }
    }
      
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }
 

}
