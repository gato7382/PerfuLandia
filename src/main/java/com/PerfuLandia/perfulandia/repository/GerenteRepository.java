package com.PerfuLandia.perfulandia.repository;

import com.PerfuLandia.perfulandia.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer> {
    List<Gerente> findByAdminId(Integer adminId);
}