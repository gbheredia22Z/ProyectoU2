package com.example.proyectou2.controller;



import com.example.proyectou2.entities.Cultivos;
import com.example.proyectou2.repository.CultivosRepo;
import com.example.proyectou2.service.CultivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cultivos")
public class CultivosController {

    @Autowired
    private CultivosService cultivosService;
    @Autowired
    private CultivosRepo cultivosRepo;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Cultivos>> getAllCultivos(){
        return ResponseEntity.ok().body(cultivosService.getAllCultivos());
    }
    @PostMapping(path = "/add")
    public ResponseEntity<Cultivos> createCultivo(@RequestBody Cultivos cultivos) {
        return new ResponseEntity<>(cultivosService.createCultivo(cultivos), HttpStatus.CREATED);
    }
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Cultivos> getCultivosById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(cultivosService.getCultivosById(id));
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteCultivosById(@PathVariable Long id){
        cultivosService.deleteCultivosById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Cultivos> updateCultivosById (@PathVariable("id") long id, @RequestBody Cultivos cultivos) {
        Optional<Cultivos> cultivosData = cultivosRepo.findById(id);

        if (cultivosData.isPresent()) {
            Cultivos _cultivos = cultivosData.get();
            _cultivos.setNombre(cultivos.getNombre());
            _cultivos.setTipo(cultivos.getTipo());
            _cultivos.setTamaño(cultivos.getTamaño());
            _cultivos.setTipo_suelo(cultivos.getTipo_suelo());
            _cultivos.setFecha_siembra(cultivos.getFecha_siembra());
            _cultivos.setFecha_cosecha(cultivos.getFecha_cosecha());
            _cultivos.setId_proveedor(cultivos.getId_proveedor());
            _cultivos.setEstado(cultivos.getEstado());
            _cultivos.setId_campo(cultivos.getId_campo());
            _cultivos.setId_producto(cultivos.getId_producto());
            return new ResponseEntity<>(cultivosRepo.save(_cultivos), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
