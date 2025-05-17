package com.PerfuLandia.perfulandia.controller;

import com.PerfuLandia.perfulandia.model.Cliente;
import com.PerfuLandia.perfulandia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> Listar(){
        List<Cliente> clientes = clienteService.findAll();
        if (clientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente){
        Cliente guardarCliente = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardarCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Integer id, @RequestBody Cliente cliente){
        try {
            Cliente pac = clienteService.findById(id);
            pac.setId(id);
            pac.setNombre(cliente.getNombre());
            pac.setCorreo(cliente.getCorreo());
            pac.setContraseña(cliente.getContraseña());

            clienteService.save(pac);
            return ResponseEntity.ok(cliente);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id){
        try {
            clienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return  ResponseEntity.notFound().build();
        }
    }
}
