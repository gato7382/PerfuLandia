package com.PerfuLandia.perfulandia.service;

import com.PerfuLandia.perfulandia.model.Admin;
import com.PerfuLandia.perfulandia.model.Cliente;
import com.PerfuLandia.perfulandia.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findById(int id){
        return adminRepository.findById(id).get();
    }

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    public void delete(Integer id) {
        adminRepository.deleteById(id);
    }
}