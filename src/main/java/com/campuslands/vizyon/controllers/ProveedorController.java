package com.campuslands.vizyon.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.vizyon.dtos.ProveedorDTO;
import com.campuslands.vizyon.services.ServiceProveedor;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/proveedor")
@AllArgsConstructor
public class ProveedorController {
    
    private ServiceProveedor serviceProveedor;

    @GetMapping
    @JsonView(ProveedorDTO.class)
    public ResponseEntity<List<ProveedorDTO>> getAllProveedores() {
        List<ProveedorDTO> proveedores = serviceProveedor.getProveedores();
        if (proveedores.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(proveedores);
        }
    }

}
