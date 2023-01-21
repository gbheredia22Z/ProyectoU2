package com.example.proyectou2.controller;


import com.example.proyectou2.entities.Parcelas;
import com.example.proyectou2.repository.ParcelasRepo;
import com.example.proyectou2.service.ParcelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("parcelas")
public class ParcelasController {

    @Autowired
    private ParcelasService parcelasService;
    @Autowired
    private ParcelasRepo parcelasRepo;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Parcelas>> getAllParcelas(){
        return ResponseEntity.ok().body(parcelasService.getAllParcelas());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Parcelas> createParcela(@RequestBody Parcelas parcelas) {
        return new ResponseEntity<>(parcelasService.createParcela(parcelas), HttpStatus.CREATED);
    }
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Parcelas> getAParcelasById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(parcelasService.getParcelasById(id));
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteParcelasById(@PathVariable Long id){
        parcelasService.deleteParcelasById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Parcelas> updateParcelasById (@PathVariable("id") long id, @RequestBody Parcelas parcelas) {
        Optional<Parcelas> parcelasData = parcelasRepo.findById(id);

        if (parcelasData.isPresent()) {
            Parcelas _parcelas = parcelasData.get();
            _parcelas.setNombre(parcelas.getNombre());
            _parcelas.setUbicacion(parcelas.getUbicacion());
            _parcelas.setTamaño(parcelas.getTamaño());
            _parcelas.setTipo_suelo(parcelas.getTipo_suelo());
            return new ResponseEntity<>(parcelasRepo.save(_parcelas), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }








}
