package com.PerfuLandia.perfulandia.service;

import com.PerfuLandia.perfulandia.model.Admin;
import com.PerfuLandia.perfulandia.repository.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findById(long id){
        return adminRepository.findById(id).get();
    }

    public Admin save(Admin admin){
        return adminRepository.save(admin);
    }

    public void delete(Long id){
        adminRepository.deleteById(id);
    }
}
