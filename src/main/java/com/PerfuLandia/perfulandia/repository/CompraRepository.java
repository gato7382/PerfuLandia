package com.PerfuLandia.perfulandia.repository;

import com.PerfuLandia.perfulandia.model.Compra;
import com.PerfuLandia.perfulandia.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
    List<Compra> findAll();
}
