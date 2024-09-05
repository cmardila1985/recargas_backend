package com.datacenter.apirecargas.adapters.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.datacenter.apirecargas.application.dto.TotalRecargaDTO;
import com.datacenter.apirecargas.application.service.RecargaService;
import com.datacenter.apirecargas.domain.model.Recargas;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recargas")
public class RecargaController {
 
	private final RecargaService recargaService;

    public RecargaController(RecargaService recargaService) {
        this.recargaService = recargaService;
    }

    @PostMapping("/crear")
    public Recargas crearProducto(@RequestBody Recargas recarga) {
        return recargaService.guardarRecarga(recarga);
    }
    
    @GetMapping("/recargas")
    public List<Recargas> obtenerTodosLasRecargas() {
        return recargaService.obtenerTodosLasRecargas();
    }
    
    @GetMapping("/recargas/totales")
    public List<TotalRecargaDTO> obtenerTotalPorVendedor() {
        return recargaService.obtenerTotalPorVendedor();
    }
}
