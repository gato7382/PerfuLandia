package com.PerfuLandia.perfulandia.service;

import com.PerfuLandia.perfulandia.model.Cliente;
import com.PerfuLandia.perfulandia.model.Producto;
import com.PerfuLandia.perfulandia.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    public Producto findById(int id){return productoRepository.findById(id).get();}

    public  Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public void delete(int id){
        productoRepository.deleteById(id);
    }
}
