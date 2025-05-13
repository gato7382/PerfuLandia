package com.PerfuLandia.perfulandia.service;


import com.PerfuLandia.perfulandia.model.GerenteSurcusal;
import com.PerfuLandia.perfulandia.repository.GerenteSurcusalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GerenteSurcusalService {

    @Autowired
    private GerenteSurcusalRepository gerenteSurcusalRepository;

    public List<GerenteSurcusal> findAll(){
        return gerenteSurcusalRepository.findAll();
    }

    public GerenteSurcusal findAll(long id){
        return gerenteSurcusalRepository.findById(id).get();
    }

    public GerenteSurcusal save(GerenteSurcusal gerenteSurcusal){
        return gerenteSurcusalRepository.save(gerenteSurcusal);
    }

    public void delete(Long id){
        gerenteSurcusalRepository.deleteById(id);
    }
}
