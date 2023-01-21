package com.example.proyectou2.entities;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parcelas")
public class Parcelas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String ubicacion;
    String tamaño;
    String tipo_suelo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_parcela", referencedColumnName = "id")
    Set<Empleados> empleados = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_parcela", referencedColumnName = "id")
    Set<Cultivos> cultivos = new HashSet<>();

    public Parcelas() {
    }

    public Parcelas(Long id, String nombre, String ubicacion, String tamaño, String tipo_suelo, Set<Empleados> empleados, Set<Cultivos> cultivos) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tamaño = tamaño;
        this.tipo_suelo = tipo_suelo;
        this.empleados = empleados;
        this.cultivos = cultivos;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getTipo_suelo() {
        return tipo_suelo;
    }

    public void setTipo_suelo(String tipo_suelo) {
        this.tipo_suelo = tipo_suelo;
    }

    public Set<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleados> empleados) {
        this.empleados = empleados;
    }

    public Set<Cultivos> getCultivos() {
        return cultivos;
    }

    public void setCultivos(Set<Cultivos> cultivos) {
        this.cultivos = cultivos;
    }
}
