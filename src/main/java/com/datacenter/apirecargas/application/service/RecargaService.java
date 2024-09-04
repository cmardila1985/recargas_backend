package com.datacenter.apirecargas.application.service;

 

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.apirecargas.application.dto.TotalRecargaDTO;
import com.datacenter.apirecargas.domain.model.Productos;
import com.datacenter.apirecargas.domain.model.Recargas;
import com.datacenter.apirecargas.domain.repository.RecargaRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Service
public class RecargaService {

     @Autowired
     private RecargaRepository recargaRepository;

     public void eliminarProducto(Long id) {
    	 recargaRepository.deleteById(id);
     }
     
     public List<Recargas> obtenerTodosLasRecargas() {
         return recargaRepository.findAll();
     }
     
     @PersistenceContext
     private EntityManager entityManager;

     @Transactional(readOnly = true)
     public List<TotalRecargaDTO> obtenerTotalPorVendedor() {
    	 String hql = "SELECT new com.datacenter.apirecargas.application.dto.TotalRecargaDTO(r.vendedor, o.descripcion, SUM(r.total)) " +
                 "FROM Recargas r JOIN r.operador o " + // Utilizando la relación directamente
                 "GROUP BY r.vendedor, o.descripcion";

         
         TypedQuery<TotalRecargaDTO> query = entityManager.createQuery(hql, TotalRecargaDTO.class);
         return query.getResultList();
     }

}
