package com.inventory.demo.controller;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.demo.entity.Productos;
import com.inventory.demo.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

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

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Productos> actualizarProducto(@PathVariable Long id, @RequestBody Productos producto) {
        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }
    
    @GetMapping("/total")
    public BigDecimal calcularValorTotalInventario() {
        return productoService.calcularValorTotalInventario();
    }
    
    @GetMapping("/combinaciones/{valor}")
    public List<List<String>> calcularValorTotalInventario(@PathVariable Long valor) {
        return productoService.obtenerCombinaciones(valor);
    }
}