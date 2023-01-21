package com.example.proyectou2.service;

import com.example.proyectou2.entities.Empleados;
import com.example.proyectou2.repository.EmpleadosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadosService {

    @Autowired
    private EmpleadosRepo empleadosRepo;

    public Empleados createEmpleado(Empleados empleados){
        return empleadosRepo.save(empleados);
    }

    public List<Empleados> getAllEmpleados(){
        return empleadosRepo.findAll();
    }

    public Empleados getEmpleadosById(Long id) {
        return empleadosRepo.findById(id).orElseThrow(() -> new RuntimeException("Empleado Not Found!"));
    }

    public void deleteEmpleadosById(Long id) {
        empleadosRepo.deleteById(id);
    }
}
