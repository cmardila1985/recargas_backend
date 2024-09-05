package com.datacenter.apirecargas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datacenter.apirecargas.domain.model.Operador;

public interface OperadorRepository extends JpaRepository<Operador, Long> {
	

}
