package com.datacenter.apirecargas.application.dto;

  
public class TotalRecargaDTO {
    private Long cantidadRecargas;         // Campo para la cantidad de recargas
    private Long total;                    // Campo para el total de recargas
    private String operador;                   // Campo para el operador
    private String vendedor;                   // Campo para el vendedor

    // Constructor que acepta los parámetros correctos
    public TotalRecargaDTO(Long cantidadRecargas, Long total, String operador, String vendedor) {
        this.cantidadRecargas = cantidadRecargas;
        this.total = total;
        this.operador = operador;
        this.vendedor = vendedor;
    }

 

    public Long getCantidadRecargas() {
        return cantidadRecargas;
    }

    public void setCantidadRecargas(Long cantidadRecargas) {
        this.cantidadRecargas = cantidadRecargas;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}
