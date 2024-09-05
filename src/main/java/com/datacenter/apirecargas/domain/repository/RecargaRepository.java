package com.datacenter.apirecargas.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.datacenter.apirecargas.domain.model.Recargas;

public interface RecargaRepository extends JpaRepository<Recargas, Long> {
	
 
}
