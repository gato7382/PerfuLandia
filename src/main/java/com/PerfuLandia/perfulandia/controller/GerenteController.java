package com.PerfuLandia.perfulandia.controller;

import com.PerfuLandia.perfulandia.model.Gerente;
import com.PerfuLandia.perfulandia.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gerente")
public class GerenteController {
    @Autowired
    private GerenteService gerenteService;

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<Gerente>> listarGerentesPorAdmin(
            @PathVariable("adminId") Integer adminId
    ) {
        List<Gerente> gerentes = gerenteService.findByAdminId(adminId);
        return ResponseEntity.ok(gerentes);
    }

    @PostMapping
    public ResponseEntity<Gerente> guardar(@RequestBody Gerente gerente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gerenteService.save(gerente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gerente> actualizarGerente(
            @PathVariable Integer id,
            @RequestBody Gerente gerenteActualizado
    ) {
        try {
            Gerente gerenteExistente = gerenteService.findById(id);
            gerenteExistente.setNombre(gerenteActualizado.getNombre());
            gerenteExistente.setContraseña(gerenteActualizado.getContraseña());
            gerenteExistente.setSucursal(gerenteActualizado.getSucursal());
            return ResponseEntity.ok(gerenteService.save(gerenteExistente));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        gerenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}