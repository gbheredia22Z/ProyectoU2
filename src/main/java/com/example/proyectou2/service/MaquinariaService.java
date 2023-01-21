package com.example.proyectou2.service;

import com.example.proyectou2.entities.Maquinaria;
import com.example.proyectou2.repository.MaquinariaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaquinariaService {

    @Autowired
    private MaquinariaRepo maquinariaRepo;

    public Maquinaria createMaquinaria(Maquinaria maquinarias){
        return maquinariaRepo.save(maquinarias);
    }

    public List<Maquinaria> getAllMaquinarias(){
        return maquinariaRepo.findAll();
    }

    public Maquinaria getMaquinariasById(Long id) {
        return maquinariaRepo.findById(id).orElseThrow(() -> new RuntimeException("Maquinaria Not Found!"));
    }

    public void deleteMaquinariasById(Long id) {
        maquinariaRepo.deleteById(id);
    }
}
