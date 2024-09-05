package com.datacenter.apirecargas.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datacenter.apirecargas.domain.model.Operador;
import com.datacenter.apirecargas.domain.repository.OperadorRepository;
@Service
public class OperadorService {

    @Autowired
    private OperadorRepository operadorRepository;
    
    public List<Operador> obtenerTodosOperadores() {
        return operadorRepository.findAll();
    }
    
}
