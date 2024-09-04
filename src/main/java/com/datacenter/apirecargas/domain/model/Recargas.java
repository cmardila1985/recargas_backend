package com.datacenter.apirecargas.domain.model;

 

import javax.persistence.*; 

import javax.persistence.*;

@Entity
@Table(name = "recargas")
public class Recargas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad_recargas", nullable = false)
    private Integer cantidadRecargas;

    @Column(name = "total", nullable = false)
    private Integer total;

    @Column(name = "vendedor", nullable = false, length = 300)
    private String vendedor;

    @ManyToOne
    @JoinColumn(name = "id_operadores", nullable = false)
    private Operador operador;

    // Constructor, getters, and setters
    public Recargas() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidadRecargas() {
        return cantidadRecargas;
    }

    public void setCantidadRecargas(Integer cantidadRecargas) {
        this.cantidadRecargas = cantidadRecargas;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }
}
