package com.example.proyectou2.repository;

import com.example.proyectou2.entities.Cultivos;
import com.example.proyectou2.entities.Maquinaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaquinariaRepo extends JpaRepository<Maquinaria, Long> {
}
