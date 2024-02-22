package com.inventory.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.demo.entity.Productos;

public interface ProductoRepository extends JpaRepository<Productos, Long> {
}