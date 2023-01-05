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
import com.uash.uash.repository.LavagemRepository;
import com.uash.uash.repository.UasherRepository;
import com.uash.uash.views.LavagemView;
import com.uash.uash.views.UasherView;

@RestController
@RequestMapping(path = "/api/uashers") 
public class UasherController {
    private Logger logger = LoggerFactory.getLogger(UasherController.class);
    @Autowired
    private UasherRepository uasherRepo;
    @Autowired 
    private LavagemRepository lavagemRepo; 

 
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Iterable<UasherView> getUasher() { 
        logger.info("Sending all uasher"); 
        return uasherRepo.findAllUasher(); 
    } 

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public UasherView getUasherById(@PathVariable int id) { 
        logger.info("Sending uasher with id " + id); 
        return uasherRepo.findUasherById(id); 
    } 

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response saveUasher(@RequestBody Uasher uasher) { 
      Uasher newUasher = uasherRepo.save(uasher);
        logger.info("Saving uasher"); 
        return new Response("Created uasher with id " + newUasher.getId(), newUasher);
    }

    @PutMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response updateUasher(@PathVariable int id, @RequestBody Uasher uasher) { 
        uasher.setId(id);
        uasherRepo.updateUasher(uasher);
        logger.info("Updating uasher with id " + id); 
        return new Response("Updating uasher with id " + id, uasher);
    }

    @PutMapping(path = "/updaterating/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response updateUasherRating(@PathVariable int id, @RequestBody Uasher uasher) { 
        Iterable<LavagemView> lavagens = lavagemRepo.findLavagemByUasher(id);
        int rating = 0;
        int size = 0;
        for (LavagemView lavagemView : lavagens) {
          if (lavagemView.getRating()!= null){
            rating += lavagemView.getRating();
            size++;
          }
        }
        rating = rating/size;
        uasherRepo.updateUasherRating(uasher, rating);
        logger.info("Updating uasher rating " + rating + " with id " + id); 
        return new Response("Updating uasher rating " + rating + " from uasher id " + id, uasher);
    }
    
    
   @DeleteMapping(path="/{id:[0-9]+}", produces=MediaType.APPLICATION_JSON_VALUE) 
    public Response deleteUasher(@PathVariable int id) { 
        logger.info("Deleting uasher with id " + id);
        uasherRepo.deleteUasher(id); 
        return new Response("Deleted uasher with id " + id, null); 
    }
  }