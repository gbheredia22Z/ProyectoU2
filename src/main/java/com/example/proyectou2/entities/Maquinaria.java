package com.example.proyectou2.entities;

import javax.persistence.*;

@Entity
@Table(name = "maquinaria")
public class Maquinaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String tipo;
    @Column(name = "id_empleado")
    Long id_empleado;

    String marca;
    String estado;

    public Maquinaria() {
    }

    public Maquinaria(Long id, String nombre, String tipo, Long id_empleado, String marca, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.id_empleado = id_empleado;
        this.marca = marca;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
