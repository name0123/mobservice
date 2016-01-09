package com.pes.mob.service;

import java.util.List;

import com.pes.mob.model.User;

public interface UserService {
	 
    User findById(String user_id);
    
    User fingByUserN(String userN);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    List<User> findAllUsers(); 
    
    void deleteUser(User user);
     
}
