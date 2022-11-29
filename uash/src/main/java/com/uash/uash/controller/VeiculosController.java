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
import com.uash.uash.model.Veiculo;
import com.uash.uash.repository.VeiculoRepository;
import com.uash.uash.views.VeiculoView;

@RestController
@RequestMapping(path = "/api/veiculos") 
public class VeiculosController {
    private Logger logger = LoggerFactory.getLogger(VeiculosController.class);
    @Autowired
    private VeiculoRepository veiculoRepo; 

 
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Iterable<VeiculoView> getVeiculo() { 
        logger.info("Sending all veiculo"); 
        return veiculoRepo.findAllVeiculo(); 
    } 
    
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response saveVeiculo(@RequestBody Veiculo veiculo) { 
      Veiculo newVeiculo = veiculoRepo.save(veiculo);
        logger.info("Saving veiculo"); 
        return new Response("Created veiculo with id " + newVeiculo.getId(), newVeiculo);
    }

    @PutMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response updateVeiculo(@RequestBody Veiculo veiculo) { 
      Integer veiculoId = veiculoRepo.updateVeiculo(veiculo);
        logger.info("Updating veiculo with id " + veiculoId); 
        return new Response("Updating veiculo with id " + veiculoId, veiculo);
    }
    
    
   @DeleteMapping(path="/{id:[0-9]+}", produces=MediaType.APPLICATION_JSON_VALUE) 
    public Response deleteVeiculo(@PathVariable int id) { 
        logger.info("Deleting veiculo with id " + id);
        veiculoRepo.deleteVeiculo(id); 
        return new Response("Deleted veiculo with id " + id, null); 
    }
  }