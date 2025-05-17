package com.PerfuLandia.perfulandia.controller;

import com.PerfuLandia.perfulandia.model.Compra;
import com.PerfuLandia.perfulandia.model.CompraDTO;
import com.PerfuLandia.perfulandia.service.CompraService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/compras")
public class CompraController {
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public Compra realizarCompra(@RequestBody CompraDTO compraDTO) {
        return compraService.realizarCompra(compraDTO);
    }

    @GetMapping
    public List<Compra> listarCompras() {
        return compraService.listarCompras();
    }

    @DeleteMapping("/{id}")
    public void eliminarCompra(@PathVariable int id) {
        compraService.eliminarCompra(id);
    }
}

