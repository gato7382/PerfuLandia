package com.PerfuLandia.perfulandia.controller;

import com.PerfuLandia.perfulandia.model.Admin;
import com.PerfuLandia.perfulandia.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ResponseEntity<List<Admin>> Listar(){
        List<Admin> admins = adminService.findAll();
        if (admins.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(admins);
    }

    @PostMapping
    public ResponseEntity<Admin> guardar(@RequestBody Admin admin){
        Admin productoNuevo = adminService.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }
