package com.PerfuLandia.perfulandia.service;

import com.PerfuLandia.perfulandia.model.Gerente;
import com.PerfuLandia.perfulandia.repository.EmpleadoRepository;
import com.PerfuLandia.perfulandia.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GerenteService {
    @Autowired
    private GerenteRepository gerenteRepository;

    public List<Gerente> findByAdminId(Integer adminId) {
        return gerenteRepository.findByAdminId(adminId);
    }

    public Gerente save(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    public Gerente findById(Integer id) {
        Gerente gerente = gerenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gerente no encontrado"));

        // Forzar carga de empleados si es Lazy y calcular cantidad
        if (gerente.getEmpleados() != null) {
            gerente.setCantidadEmpleados(gerente.getEmpleados().size());
        }
        return gerente;
    }

    public void delete(Integer id) {
        gerenteRepository.deleteById(id);
    }

}