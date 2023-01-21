package com.example.proyectou2.controller;



import com.example.proyectou2.entities.Empleados;
import com.example.proyectou2.repository.EmpleadosRepo;
import com.example.proyectou2.service.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadosService empleadosService;
    @Autowired
    private EmpleadosRepo empleadosRepo;

    @GetMapping(path = "/get")
    public ResponseEntity<List<Empleados>> getAllEmpleados(){
        return ResponseEntity.ok().body(empleadosService.getAllEmpleados());
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Empleados> createEmpleado(@RequestBody Empleados empleados) {
        return new ResponseEntity<>(empleadosService.createEmpleado(empleados), HttpStatus.CREATED);
    }
    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Empleados> getEmpleadosById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(empleadosService.getEmpleadosById(id));
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteEmpleadosById(@PathVariable Long id){
        empleadosService.deleteEmpleadosById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Empleados> updateEmpleadosById (@PathVariable("id") long id, @RequestBody Empleados empleados) {
        Optional<Empleados> empleadosData = empleadosRepo.findById(id);

        if (empleadosData.isPresent()) {
            Empleados _empleados = empleadosData.get();
            _empleados.setNombre(_empleados.getNombre());
            _empleados.setEdad(_empleados.getEdad());
            _empleados.setCedula(_empleados.getCedula());
            return new ResponseEntity<>(empleadosRepo.save(_empleados), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }











}
