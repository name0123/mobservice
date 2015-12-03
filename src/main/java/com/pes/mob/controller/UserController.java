package com.pes.mob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pes.mob.model.User;
import com.pes.mob.service.UserService;

@RestController
@RequestMapping(value="/users", headers = "Accept=application/json")
public class UserController {
    @Autowired 
    UserService userService;
	
	
    @RequestMapping(value = { "/getall" }, method = RequestMethod.GET)
    public List<User> getAllUsers() {
       return userService.findAllUsers();
       
    }
    
    @RequestMapping(value = { "/get" }, method = RequestMethod.GET)
    public User getUser(@RequestParam(value="id", defaultValue="") String id,
    					@RequestParam(value="userN", defaultValue="") String userN) {
    	if (!id.equals("")) return userService.findById(id);  
    	else if (!userN.equals("")) return userService.fingByUserN(userN);
    	return null;
    }
    
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public ResponseEntity<User> savePlace(@RequestBody User user) { 
        userService.saveUser(user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
