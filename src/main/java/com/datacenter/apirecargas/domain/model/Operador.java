package com.datacenter.apirecargas.domain.model;
 

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "operadores")
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operadores")
    private Integer idOperadores;

    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;


    // Constructor, getters, and setters
    public Operador() {}

    public Integer getIdOperadores() {
        return idOperadores;
    }

    public void setIdOperadores(Integer idOperadores) {
        this.idOperadores = idOperadores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  
}
