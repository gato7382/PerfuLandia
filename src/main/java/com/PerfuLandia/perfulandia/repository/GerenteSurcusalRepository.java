package com.PerfuLandia.perfulandia.repository;

import com.PerfuLandia.perfulandia.model.GerenteSurcusal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteSurcusalRepository extends JpaRepository<GerenteSurcusal, Long> {
}
