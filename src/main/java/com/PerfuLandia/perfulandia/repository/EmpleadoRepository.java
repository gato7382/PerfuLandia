package com.PerfuLandia.perfulandia.repository;

import com.PerfuLandia.perfulandia.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    List<Empleado> findByJefeId(Integer gerenteId);
    int countByJefeId(Integer gerenteId); // Para cantidadEmpleados en Gerente
}