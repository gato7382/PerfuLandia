package com.PerfuLandia.perfulandia.controller;

import com.PerfuLandia.perfulandia.model.Producto;
import com.PerfuLandia.perfulandia.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> Listar(){
        List<Producto> productos = productoService.findAll();
        if (productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
        Producto guardarProducto = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardarProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto producto){
        try {
            Producto pac = productoService.findById(id);
            pac.setId(id);
            pac.setNombreProducto(producto.getNombreProducto());
            pac.setCantidadStock(producto.getCantidadStock());
            pac.setPrecio(producto.getPrecio());

            productoService.save(pac);
            return ResponseEntity.ok(producto);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id){
        try {
            productoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return  ResponseEntity.notFound().build();
        }
    }
}
