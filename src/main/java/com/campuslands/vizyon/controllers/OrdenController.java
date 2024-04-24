package com.campuslands.vizyon.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.vizyon.dtos.OrdenDTO;
import com.campuslands.vizyon.services.ServiceOrden;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/orden")
@AllArgsConstructor
public class OrdenController {
    
    private ServiceOrden serviceOrden;

    @GetMapping
    @JsonView(OrdenDTO.class)
    public ResponseEntity<List<OrdenDTO>> getOrdenes() {
        List<OrdenDTO> ordenes = serviceOrden.findAll();
        if (ordenes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(ordenes);
            
        }
    }

    @GetMapping("/estado")
    @JsonView(OrdenDTO.class)
    public ResponseEntity<List<OrdenDTO>> getOrdenesByState() {
        List<OrdenDTO> ordenes = serviceOrden.findByState();
        if (ordenes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(ordenes);
        }
    }


}
