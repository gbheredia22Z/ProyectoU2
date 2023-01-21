package com.example.proyectou2.service;

import com.example.proyectou2.entities.Cultivos;
import com.example.proyectou2.repository.CultivosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CultivosService {
    @Autowired
    private CultivosRepo cultivosRepo;

    public Cultivos createCultivo(Cultivos cultivos){
        return cultivosRepo.save(cultivos);
    }

    public List<Cultivos> getAllCultivos(){
        return cultivosRepo.findAll();
    }

    public Cultivos getCultivosById(Long id) {
        return cultivosRepo.findById(id).orElseThrow(() -> new RuntimeException("Cultivo Not Found!"));
    }

    public void deleteCultivosById(Long id) {
        cultivosRepo.deleteById(id);
    }

}
