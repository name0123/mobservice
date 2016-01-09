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
 

    public void updateUser(User user) {
        User entity = dao.findById(user.getUser_id());
        entity.setName(user.getName());
        entity.setUserN(user.getUserN());
        entity.setSurname(user.getSurname());
        entity.setPassword(user.getPassword());
        entity.setPhotopath(user.getPhotopath());
        dao.saveUser(entity);
        
    }
      
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

	@Override
	public User fingByUserN(String userN) {
		return dao.findByUserN(userN);
	}

	@Override
	public void deleteUser(User user) {
		dao.deleteUser(user);
		
	}
 

}
