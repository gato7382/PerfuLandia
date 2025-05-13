package com.PerfuLandia.perfulandia.controller;


import com.PerfuLandia.perfulandia.model.GerenteSurcusal;
import com.PerfuLandia.perfulandia.service.GerenteSurcusalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gerentesurcusal")

public class GerenteSurcusalController {

    @Autowired
    private GerenteSurcusalService gerenteSurcusalService;

    @GetMapping
    ResponseEntity<List<GerenteSurcusal>> Listar(){
        List<GerenteSurcusal> gerenteSurcusals = gerenteSurcusalService.findAll();
        if (gerenteSurcusals.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(gerenteSurcusals);
    }

}
