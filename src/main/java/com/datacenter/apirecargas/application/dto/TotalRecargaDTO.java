package com.datacenter.apirecargas.application.dto;

  
public class TotalRecargaDTO {
    private String vendedor;             // Campo para el vendedor
    private String operadorDescripcion;   // Campo para la descripción del operador
    private Long total;                   // Campo para el total de recargas

    // Constructor que acepta los parámetros correctos
    public TotalRecargaDTO(String vendedor, String operadorDescripcion, Long total) {
        this.vendedor = vendedor;
        this.operadorDescripcion = operadorDescripcion;
        this.total = total;
    }

    // Getters y Setters
    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getOperadorDescripcion() {
        return operadorDescripcion;
    }

    public void setOperadorDescripcion(String operadorDescripcion) {
        this.operadorDescripcion = operadorDescripcion;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
