package com.pes.mob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public  @ResponseBody List<User> getAllUsers() {
       return userService.findAllUsers();
       
    }
    
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public ResponseEntity<User> savePlace(@RequestBody User user) { 
        userService.saveUser(user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
