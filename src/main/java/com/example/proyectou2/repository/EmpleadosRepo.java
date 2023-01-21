package com.example.proyectou2.repository;

import com.example.proyectou2.entities.Cultivos;
import com.example.proyectou2.entities.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadosRepo extends JpaRepository<Empleados, Long> {
}
