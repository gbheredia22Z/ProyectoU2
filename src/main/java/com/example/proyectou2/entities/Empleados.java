package com.example.proyectou2.entities;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    Integer edad;
    String cedula;

    @Column(name = "id_parcela")
    Long id_parcela;

    Double sueldo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empleado", referencedColumnName = "id")
    Set<Maquinaria> maquinarias = new HashSet<>();

    public Empleados() {
    }

    public Empleados(Long id, String nombre, Integer edad, String cedula, Long id_parcela, Double sueldo, Set<Maquinaria> maquinarias) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.id_parcela = id_parcela;
        this.sueldo = sueldo;
        this.maquinarias = maquinarias;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Long getId_parcela() {
        return id_parcela;
    }

    public void setId_parcela(Long id_parcela) {
        this.id_parcela = id_parcela;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public Set<Maquinaria> getMaquinarias() {
        return maquinarias;
    }

    public void setMaquinarias(Set<Maquinaria> maquinarias) {
        this.maquinarias = maquinarias;
    }
}
