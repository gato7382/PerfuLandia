package com.PerfuLandia.perfulandia.controller;

import com.PerfuLandia.perfulandia.model.Admin;
import com.PerfuLandia.perfulandia.model.Cliente;
import com.PerfuLandia.perfulandia.service.AdminService;
import com.PerfuLandia.perfulandia.service.ClienteService;
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
    @Autowired
    private ClienteService clienteService;

    // --- Endpoints para Admins ---
    @GetMapping
    public ResponseEntity<List<Admin>> listarAdmins() {
        return ResponseEntity.ok(adminService.findAll());
    }

    @PostMapping
    public ResponseEntity<Admin> crearAdmin(@RequestBody Admin admin) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.save(admin));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> actualizarAdmin(
            @PathVariable Integer id,
            @RequestBody Admin adminActualizado
    ) {
        try {
            Admin adminExistente = adminService.findById(id);
            adminExistente.setNombre(adminActualizado.getNombre());
            adminExistente.setContraseña(adminActualizado.getContraseña());
            return ResponseEntity.ok(adminService.save(adminExistente));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAdmin(@PathVariable Integer id) {
        adminService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // --- Gestión de Clientes ---
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> actualizarClienteAdmin(
            @PathVariable Integer id,
            @RequestBody Cliente cliente
    ) {
        cliente.setId(id);
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}