package com.example.proyectou2.controller;


import com.example.proyectou2.entities.Maquinaria;
import com.example.proyectou2.repository.MaquinariaRepo;
import com.example.proyectou2.service.MaquinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maquinaria")
public class MaquinariaController {

    @Autowired
    private MaquinariaService maquinariaService;
    @Autowired
    private MaquinariaRepo maquinariaRepo;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Maquinaria>> getAllMaquinarias(){
        return ResponseEntity.ok().body(maquinariaService.getAllMaquinarias());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Maquinaria> createMaquinaria(@RequestBody Maquinaria maquinarias) {
        return new ResponseEntity<>(maquinariaService.createMaquinaria(maquinarias), HttpStatus.CREATED);
    }
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Maquinaria> getAnimalById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(maquinariaService.getMaquinariasById(id));
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteMaquinariasById(@PathVariable Long id){
        maquinariaService.deleteMaquinariasById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Maquinaria> updateMaquinariasById (@PathVariable("id") long id, @RequestBody Maquinaria maquinarias) {
        Optional<Maquinaria> maquinariaData = maquinariaRepo.findById(id);

        if (maquinariaData.isPresent()) {
            Maquinaria _maquinaria = maquinariaData.get();
            _maquinaria.setNombre(maquinarias.getNombre());
            _maquinaria.setTipo(maquinarias.getTipo());
            _maquinaria.setId_empleado(maquinarias.getId_empleado());
            _maquinaria.setMarca(maquinarias.getMarca());
            _maquinaria.setEstado(maquinarias.getEstado());
            return new ResponseEntity<>(maquinariaRepo.save(_maquinaria), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
