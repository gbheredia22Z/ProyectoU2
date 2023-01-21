package com.example.proyectou2.repository;

import com.example.proyectou2.entities.Cultivos;
import com.example.proyectou2.entities.Parcelas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelasRepo extends JpaRepository<Parcelas, Long> {
}
