package com.campuslands.vizyon.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campuslands.vizyon.config.OrdenDTOConverter;
import com.campuslands.vizyon.dtos.OrdenDTO;
import com.campuslands.vizyon.repositories.RepositoryOrden;
import com.campuslands.vizyon.repositories.entities.Orden;
import com.campuslands.vizyon.services.ServiceOrden;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceOrdenImpl implements ServiceOrden{
    
    @Autowired
    private RepositoryOrden repositoryOrden;

    @Autowired
    private OrdenDTOConverter converter;

    @Override
    public List<OrdenDTO> findAll() {
        List<Orden> ordenes = (List<Orden>) repositoryOrden.findAll();
        return ordenes.stream()
                .map(orden -> converter.convertToDTO(orden))
                .toList();
    }

    @Override
    public List<OrdenDTO> findByState() {
        List<Orden> ordenes = (List<Orden>) repositoryOrden.findAll();
        return ordenes.stream()
                .filter(orden -> orden.getEstado().getId() == 2)
                .map(orden -> converter.convertToDTO(orden))
                .toList();
    }

    

}
