package com.PerfuLandia.perfulandia.service;

import com.PerfuLandia.perfulandia.model.Empleado;
import com.PerfuLandia.perfulandia.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> findByJefeId(Integer gerenteId) {
        return empleadoRepository.findByJefeId(gerenteId);
    }

    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado findById(int id){
        return empleadoRepository.findById(id).get();
    }

    public void delete(Integer id) {
        empleadoRepository.deleteById(id);
    }
}