package com.datacenter.apirecargas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datacenter.apirecargas.domain.model.Productos;

public interface ProductoRepository extends JpaRepository<Productos, Long> {
}