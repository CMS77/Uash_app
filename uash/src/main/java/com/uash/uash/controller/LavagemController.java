package com.uash.uash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uash.uash.model.Lavagem;
import com.uash.uash.repository.LavagemRepository;

@RestController
public class LavagemController {
    @Autowired
    private LavagemRepository lavagemRepo;
       
    @GetMapping("/lavagens")
    public List<Lavagem> listAll() {
        return lavagemRepo.findAll();
    }

    
}
