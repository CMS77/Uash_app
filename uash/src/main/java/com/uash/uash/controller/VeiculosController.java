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

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public VeiculoView getVeiculoById(@PathVariable int id) { 
        logger.info("Sending veiculo with id " + id); 
        return veiculoRepo.findVeiculoById(id);
    }

    @GetMapping(path = "/findmatricula/{matricula}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public VeiculoView findVeiculoByMatricula(@PathVariable String matricula) { 
        logger.info("Sending veiculo with matricula " + matricula); 
        return veiculoRepo.findVeiculoByMatricula(matricula);
    }

    @GetMapping(path = "/finduser/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public VeiculoView findVeiculoByUser(@PathVariable int id) { 
        logger.info("Sending veiculo with user " + id); 
        return veiculoRepo.findVeiculoByUser(id);
    }
    
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response saveVeiculo(@RequestBody Veiculo veiculo) { 
      Veiculo newVeiculo = veiculoRepo.save(veiculo);
        logger.info("Saving veiculo"); 
        return new Response("Created veiculo with id " + newVeiculo.getId(), newVeiculo);
    }

    @PutMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Response updateVeiculo(@PathVariable int id, @RequestBody Veiculo veiculo) { 
        veiculo.setId(id);
        veiculoRepo.updateVeiculo(veiculo);
        logger.info("Updating veiculo with id " + id); 
        return new Response("Updating veiculo with id " + id, veiculo);
    }
        
    
   @DeleteMapping(path="/{id:[0-9]+}", produces=MediaType.APPLICATION_JSON_VALUE) 
    public Response deleteVeiculo(@PathVariable int id) { 
        logger.info("Deleting veiculo with id " + id);
        veiculoRepo.deleteVeiculo(id); 
        return new Response("Deleted veiculo with id " + id, null); 
    }
  }