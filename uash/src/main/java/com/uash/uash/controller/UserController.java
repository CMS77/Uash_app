package com.uash.uash.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uash.uash.model.Response;
import com.uash.uash.model.User;
import com.uash.uash.repository.UserRepository;
import com.uash.uash.views.UserView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@RestController
@RequestMapping(path = "/api/users") 
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepo; 
 
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Iterable<UserView> getUsers() { 
        logger.info("Sending all user"); 
        return userRepo.findAllUsers(); 
    } 
    
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response saveUser(@RequestBody User user) { 
      User newUser = userRepo.save(user);
        logger.info("Saving user"); 
        return new Response("Created user with id " + newUser.getId(), newUser);
    }

    @PutMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response updateUser(@RequestBody User user) { 
      Integer userId = userRepo.updateUser(user, null);
        logger.info("Updating user with id " + userId); 
        return new Response("Updating user with id " + userId, user);
    }
    
    
   @DeleteMapping(path="/{id:[0-9]+}", produces=MediaType.APPLICATION_JSON_VALUE) 
    public Response deleteUser(@PathVariable int id) { 
        logger.info("Deleting user with id " + id);
        userRepo.deleteUser(id); 
        return new Response("Deleted user with id " + id, null); 
    }
  }
