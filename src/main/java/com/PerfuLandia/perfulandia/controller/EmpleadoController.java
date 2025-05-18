package com.PerfuLandia.perfulandia.controller;

import com.PerfuLandia.perfulandia.model.Empleado;
import com.PerfuLandia.perfulandia.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/gerente/{gerenteId}")
    public ResponseEntity<List<Empleado>> listarPorGerente(@PathVariable Integer gerenteId) {
        return ResponseEntity.ok(empleadoService.findByJefeId(gerenteId));
    }

    @PostMapping
    public ResponseEntity<Empleado> guardar(@RequestBody Empleado empleado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(
            @PathVariable Integer id,
            @RequestBody Empleado empleadoActualizado
    ) {
        try {
            Empleado empleadoExistente = empleadoService.findById(id);
            empleadoExistente.setNombre(empleadoActualizado.getNombre());
            empleadoExistente.setContraseña(empleadoActualizado.getContraseña());
            empleadoExistente.setCodigoEmpleado(empleadoActualizado.getCodigoEmpleado());
            return ResponseEntity.ok(empleadoService.save(empleadoExistente));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}