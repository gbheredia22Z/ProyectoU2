package com.example.proyectou2.service;

import com.example.proyectou2.entities.Parcelas;
import com.example.proyectou2.repository.ParcelasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelasService {

    @Autowired
    private ParcelasRepo parcelasRepo;

    public Parcelas createParcela(Parcelas parcelas){
        return parcelasRepo.save(parcelas);
    }

    public List<Parcelas> getAllParcelas(){
        return parcelasRepo.findAll();
    }

    public Parcelas getParcelasById(Long id) {
        return parcelasRepo.findById(id).orElseThrow(() -> new RuntimeException("Parcela Not Found!"));
    }

    public void deleteParcelasById(Long id) {
        parcelasRepo.deleteById(id);
    }

}
