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
import com.uash.uash.model.Uasher;
import com.uash.uash.repository.UasherRepository;
import com.uash.uash.views.UasherView;

@RestController
@RequestMapping(path = "/api/uashers") 
public class UasherController {
    private Logger logger = LoggerFactory.getLogger(UasherController.class);
    @Autowired
    private UasherRepository uasherRepo; 

 
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Iterable<UasherView> getUasher() { 
        logger.info("Sending all uasher"); 
        return uasherRepo.findAllUasher(); 
    } 
    
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response saveUasher(@RequestBody Uasher uasher) { 
      Uasher newUasher = uasherRepo.save(uasher);
        logger.info("Saving uasher"); 
        return new Response("Created uasher with id " + newUasher.getId(), newUasher);
    }

    @PutMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response updateUasher(@RequestBody Uasher uasher) { 
      Integer uasherId = uasherRepo.updateUasher(uasher);
        logger.info("Updating uasher with id " + uasherId); 
        return new Response("Updating uasher with id " + uasherId, uasher);
    }
    
    
   @DeleteMapping(path="/{id:[0-9]+}", produces=MediaType.APPLICATION_JSON_VALUE) 
    public Response deleteUasher(@PathVariable int id) { 
        logger.info("Deleting uasher with id " + id);
        uasherRepo.deleteUasher(id); 
        return new Response("Deleted user with id " + id, null); 
    }
  }