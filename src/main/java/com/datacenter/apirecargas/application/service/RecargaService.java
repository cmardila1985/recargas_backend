package com.datacenter.apirecargas.application.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.datacenter.apirecargas.application.dto.TotalRecargaDTO;
import com.datacenter.apirecargas.domain.model.Recargas;
import com.datacenter.apirecargas.domain.repository.RecargaRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
 
@Service
public class RecargaService {

     @Autowired
     private RecargaRepository recargaRepository;

     
     public List<Recargas> obtenerTodosLasRecargas() {
         return recargaRepository.findAll();
     }
    
     
     public Recargas guardarRecarga(Recargas recarga) {
         return recargaRepository.save(recarga);
     }
     
     @PersistenceContext
     private EntityManager entityManager;

     @Transactional(readOnly = true)
     public List<TotalRecargaDTO> obtenerTotalPorVendedor() {
    	 String hql = "SELECT new com.datacenter.apirecargas.application.dto.TotalRecargaDTO(" +
                 "COUNT(r.cantidadRecargas), SUM(r.total), o.descripcion, r.vendedor) " + // Cambios realizados aquí
                 "FROM Recargas r JOIN r.operador o " +
                 "GROUP BY r.vendedor, o.descripcion"; // Asegúrate de agrupar correctamente

		    TypedQuery<TotalRecargaDTO> query = entityManager.createQuery(hql, TotalRecargaDTO.class);
		    return query.getResultList();
     }

}
