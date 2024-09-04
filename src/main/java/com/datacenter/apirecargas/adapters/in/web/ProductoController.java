package com.datacenter.apirecargas.adapters.in.web;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datacenter.apirecargas.application.service.ProductoService;
import com.datacenter.apirecargas.application.service.RecargaService;
import com.datacenter.apirecargas.domain.model.Productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    
    @Autowired
    private RecargaService recargaService;
    

    @GetMapping("/productos")
    public List<Productos> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }
    
    @GetMapping("/{id}")
    public Optional<Productos> obtenerProductoPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id);
    }

    @PostMapping("/crear")
    public Productos crearProducto(@RequestBody Productos producto) {
        return productoService.guardarProducto(producto);
    }

   

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
    
    @GetMapping("/total")
    public BigDecimal calcularValorTotalInventario() {
        return productoService.calcularValorTotalInventario();
    }
    
    
}