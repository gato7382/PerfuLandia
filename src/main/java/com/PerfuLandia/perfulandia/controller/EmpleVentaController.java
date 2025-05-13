package com.PerfuLandia.perfulandia.controller;


import com.PerfuLandia.perfulandia.model.EmpleadoVentas;
import com.PerfuLandia.perfulandia.service.EmpleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmpleVentaController {

    @Autowired
    private EmpleVentaService empleService;

    @GetMapping
    public ResponseEntity<List<EmpleadoVentas>> Listar(){
        List<EmpleadoVentas> empleados = empleService.findAll();
        if (empleados.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(empleados);
    }
    @PostMapping
    public ResponseEntity<EmpleadoVentas> guardar(@RequestBody EmpleadoVentas empleado){
        EmpleadoVentas agregarProducto = empleService.save(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(agregarProducto);
    }

}
