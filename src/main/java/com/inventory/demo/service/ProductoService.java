package com.inventory.demo.service;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.inventory.demo.entity.Productos;
import com.inventory.demo.repository.ProductoRepository;

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

    public ResponseEntity<Productos> actualizarProducto(Long id, Productos producto) {
        Productos productoExistente = productoRepository.findById(id)
                .orElseThrow();

        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());

        Productos productoActualizado = productoRepository.save(productoExistente);
        return ResponseEntity.ok(productoActualizado);
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
    
    
    public List<List<String>> obtenerCombinaciones(long valor) {
        List<Productos> productosOrdenados = productoRepository.findAll().stream()
                .sorted(Comparator.comparingLong(Productos::getPrecio))
                .collect(Collectors.toList());

        List<List<String>> combinaciones = new ArrayList<>();

        for (int i = 0; i < productosOrdenados.size(); i++) {
            for (int j = i + 1; j < productosOrdenados.size(); j++) {
                long suma2 = productosOrdenados.get(i).getPrecio() + productosOrdenados.get(j).getPrecio();
                if (suma2 <= valor) {
                    combinaciones.add(List.of(productosOrdenados.get(i).getNombre(), productosOrdenados.get(j).getNombre(), String.valueOf(suma2)));
                }

                for (int k = j + 1; k < productosOrdenados.size(); k++) {
                    long suma3 = suma2 + productosOrdenados.get(k).getPrecio();
                    if (suma3 <= valor) {
                        combinaciones.add(List.of(productosOrdenados.get(i).getNombre(), productosOrdenados.get(j).getNombre(), productosOrdenados.get(k).getNombre(), String.valueOf(suma3)));
                    }
                }
            }
        }

        return combinaciones.stream()
                .sorted(Comparator.comparing(comb -> Long.parseLong(comb.get(comb.size() - 1)), Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toList());
    }
}
