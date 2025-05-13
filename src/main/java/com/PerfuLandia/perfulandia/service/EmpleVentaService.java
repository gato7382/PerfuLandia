package com.PerfuLandia.perfulandia.service;

import com.PerfuLandia.perfulandia.model.EmpleadoVentas;
import com.PerfuLandia.perfulandia.repository.EmpleVentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmpleVentaService {

    @Autowired
    private EmpleVentaRepository empleRepository;

    public List<EmpleadoVentas> findAll(){
        return empleRepository.findAll();
    }

    public EmpleadoVentas findById(long id){
        return empleRepository.findById(id).get();
    }

    public EmpleadoVentas save(EmpleadoVentas empleado) {
        return empleRepository.save(empleado);
    }

    public void delete(Long id){
        empleRepository.deleteById(id);
    }
}
