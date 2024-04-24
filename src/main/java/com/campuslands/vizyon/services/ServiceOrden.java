package com.campuslands.vizyon.services;

import java.util.List;

import com.campuslands.vizyon.dtos.OrdenDTO;

public interface ServiceOrden {
    
    List<OrdenDTO> findAll();

    List<OrdenDTO> findByState();

}
