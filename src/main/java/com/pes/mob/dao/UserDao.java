package com.pes.mob.dao;



import java.util.List;

import com.pes.mob.model.*;


public interface UserDao {
	
    User findById(String user_id);
    
    void saveUser(User user);
         
    List<User> findAllUsers();
 
}

