package com.PerfuLandia.perfulandia.service;

import com.PerfuLandia.perfulandia.model.Empleado;
import com.PerfuLandia.perfulandia.repository.EmpleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmpleService {

    @Autowired
    private EmpleRepository empleRepository;

    public List<Empleado> findAll(){
        return empleRepository.findAll();
    }

    public Empleado findById(long id){
        return empleRepository.findById(id).get();
    }

    public  Empleado save(Empleado empleado) {
        return empleRepository.save(empleado);
    }

    public void delete(Long id){
        empleRepository.deleteById(id);
    }
}
