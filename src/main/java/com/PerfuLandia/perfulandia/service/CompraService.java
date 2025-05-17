package com.PerfuLandia.perfulandia.service;

import com.PerfuLandia.perfulandia.model.Cliente;
import com.PerfuLandia.perfulandia.model.Compra;
import com.PerfuLandia.perfulandia.model.CompraDTO;
import com.PerfuLandia.perfulandia.model.Producto;
import com.PerfuLandia.perfulandia.repository.ClienteRepository;
import com.PerfuLandia.perfulandia.repository.CompraRepository;
import com.PerfuLandia.perfulandia.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CompraService {

    private final CompraRepository compraRepository;
    private final ProductoRepository productoRepository;
    private final ClienteRepository clienteRepository;

    public CompraService(CompraRepository compraRepository, ProductoRepository productoRepository, ClienteRepository clienteRepository) {
        this.compraRepository = compraRepository;
        this.productoRepository = productoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Compra realizarCompra(CompraDTO compraDTO) {
        Producto producto = productoRepository.findById(compraDTO.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if (producto.getCantidadStock() < compraDTO.getCantidad()) {
            throw new RuntimeException("Stock insuficiente");
        }

        // Buscar cliente (completo) desde la BD
        Cliente cliente = clienteRepository.findById(compraDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Actualizar stock
        producto.setCantidadStock(producto.getCantidadStock() - compraDTO.getCantidad());
        productoRepository.save(producto);

        // Crear y guardar la compra
        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setProducto(producto);
        compra.setCantidad(compraDTO.getCantidad());

        return compraRepository.save(compra);
    }

    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    @Transactional
    public void eliminarCompra(int id) {
        Compra compra = compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));

        // Restaurar stock
        Producto producto = compra.getProducto();
        producto.setCantidadStock(producto.getCantidadStock() + compra.getCantidad());
        productoRepository.save(producto);

        compraRepository.delete(compra);
    }
}