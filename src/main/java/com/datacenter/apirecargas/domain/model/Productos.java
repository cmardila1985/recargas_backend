package com.datacenter.apirecargas.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Long precio;
    private Long stock;

    public Productos() {
    }

    public Productos(String nombre, String descripcion, Long precio, Long stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    // ToString
    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
                + ", stock=" + stock + "]";
    }
}
