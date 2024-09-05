package com.datacenter.apirecargas.adapters.in.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datacenter.apirecargas.application.service.OperadorService;
import com.datacenter.apirecargas.domain.model.Operador;


import java.util.List;

@RestController
@RequestMapping("/api/v1/operadores")
public class OperadorController {
 
	private final OperadorService operadorService;

    public OperadorController(OperadorService operadorService) {
        this.operadorService = operadorService;
    }

    @GetMapping("/operadores")
    public List<Operador> obtenerTodosOperadores() {
        return operadorService.obtenerTodosOperadores();
    }
    
}