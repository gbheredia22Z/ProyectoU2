package com.example.proyectou2.entities;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "cultivos")
public class Cultivos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String tipo;
    String tamaño;
    String tipo_suelo;
    LocalDate fecha_siembra;
    LocalDate fecha_cosecha;
    Long id_proveedor;
    String estado;
    Long id_campo;
    Long id_producto;

    @Column(name="id_parcela")
    Long id_parcela;

    public Cultivos() {
    }

    public Cultivos(Long id, String nombre, String tipo, String tamaño, String tipo_suelo, LocalDate fecha_siembra, LocalDate fecha_cosecha, Long id_proveedor, String estado, Long id_campo, Long id_producto, Long id_parcela) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tamaño = tamaño;
        this.tipo_suelo = tipo_suelo;
        this.fecha_siembra = fecha_siembra;
        this.fecha_cosecha = fecha_cosecha;
        this.id_proveedor = id_proveedor;
        this.estado = estado;
        this.id_campo = id_campo;
        this.id_producto = id_producto;
        this.id_parcela = id_parcela;
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

    public LocalDate getFecha_siembra() {
        return fecha_siembra;
    }

    public void setFecha_siembra(LocalDate fecha_siembra) {
        this.fecha_siembra = fecha_siembra;
    }

    public LocalDate getFecha_cosecha() {
        return fecha_cosecha;
    }

    public void setFecha_cosecha(LocalDate fecha_cosecha) {
        this.fecha_cosecha = fecha_cosecha;
    }

    public Long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId_campo() {
        return id_campo;
    }

    public void setId_campo(Long id_campo) {
        this.id_campo = id_campo;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public Long getId_parcela() {
        return id_parcela;
    }

    public void setId_parcela(Long id_parcela) {
        this.id_parcela = id_parcela;
    }
}
