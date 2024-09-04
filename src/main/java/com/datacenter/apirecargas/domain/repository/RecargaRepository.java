package com.datacenter.apirecargas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.datacenter.apirecargas.application.dto.TotalRecargaDTO;
import com.datacenter.apirecargas.domain.model.Recargas;

public interface RecargaRepository extends JpaRepository<Recargas, Long> {
	
 
}
