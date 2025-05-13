package com.PerfuLandia.perfulandia.repository;

import com.PerfuLandia.perfulandia.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleRepository extends JpaRepository<Empleado, Long>{
}
