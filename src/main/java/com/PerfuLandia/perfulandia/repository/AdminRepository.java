package com.PerfuLandia.perfulandia.repository;

import com.PerfuLandia.perfulandia.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}