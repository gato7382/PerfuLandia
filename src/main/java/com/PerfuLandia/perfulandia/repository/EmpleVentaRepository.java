package com.PerfuLandia.perfulandia.repository;

import com.PerfuLandia.perfulandia.model.EmpleadoVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleVentaRepository extends JpaRepository<EmpleadoVentas, Long>{
}
