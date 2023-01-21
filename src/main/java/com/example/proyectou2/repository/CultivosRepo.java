package com.example.proyectou2.repository;

import com.example.proyectou2.entities.Cultivos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultivosRepo extends JpaRepository<Cultivos, Long> {
}
