package com.datacenter.apirecargas.application.service;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.datacenter.apirecargas.domain.model.Productos;
import com.datacenter.apirecargas.domain.repository.ProductoRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Productos> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }
    

    public Optional<Productos> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Productos guardarProducto(Productos producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
    	productoRepository.deleteById(id);
    }

    
    
    public BigDecimal calcularValorTotalInventario() {
        List<Productos> productos = productoRepository.findAll();
        BigDecimal valorTotalInventario = BigDecimal.ZERO;

        for (Productos producto : productos) {
            BigDecimal precio = BigDecimal.valueOf(producto.getPrecio());
            BigDecimal stock = BigDecimal.valueOf(producto.getStock());
            valorTotalInventario = valorTotalInventario.add(precio.multiply(stock));
        }

        return valorTotalInventario;
    }
    
    
    
}
