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

import com.uash.uash.model.Lavagem;
import com.uash.uash.model.Response;
import com.uash.uash.repository.LavagemRepository;
import com.uash.uash.views.LavagemView;

@RestController
@RequestMapping(path = "/api/lavagens") 
public class LavagemController {
    private Logger logger = LoggerFactory.getLogger(LavagemController.class);
    @Autowired
    private LavagemRepository lavagemRepo; 

 
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Iterable<LavagemView> getLavagem() { 
        logger.info("Sending all lavagem"); 
        return lavagemRepo.findAllLavagem(); 
    } 

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public LavagemView getLavagemById(@PathVariable int id) { 
        logger.info("Sending lavagem with id " + id); 
        return lavagemRepo.findLavagemById(id); 
    }

    @GetMapping(path = "/finduasher/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Iterable<LavagemView> findLavagemByUasher(@PathVariable int id) { 
        logger.info("Sending all lavagem of uasher with id " + id); 
        return lavagemRepo.findLavagemByUasher(id); 
    } 

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response saveLavagem(@RequestBody Lavagem lavagem) { 
      Lavagem newLavagem = lavagemRepo.save(lavagem);
        logger.info("Saving lavagem"); 
        return new Response("Created lavagem with id " + newLavagem.getId(), newLavagem);
    }


    @PutMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response updateLavagem(@PathVariable int id, @RequestBody Lavagem lavagem) { 
        lavagem.setId(id);
        lavagemRepo.updateLavagem(lavagem);
        logger.info("Updating lavagem with id " + id); 
        return new Response("Updating lavagem with id " + id, lavagem);
    }
    
    
   @DeleteMapping(path="/{id:[0-9]+}", produces=MediaType.APPLICATION_JSON_VALUE) 
    public Response deleteLavagem(@PathVariable int id) { 
        logger.info("Deleting lavagem with id " + id);
        lavagemRepo.deleteLavagem(id); 
        return new Response("Deleted lavagem with id " + id, null); 
    }
  } 