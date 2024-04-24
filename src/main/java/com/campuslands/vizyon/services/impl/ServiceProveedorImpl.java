package com.campuslands.vizyon.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campuslands.vizyon.config.ProveedorDTOConverter;
import com.campuslands.vizyon.dtos.ProveedorDTO;
import com.campuslands.vizyon.repositories.RepositoryProveedor;
import com.campuslands.vizyon.repositories.entities.Proveedor;
import com.campuslands.vizyon.services.ServiceProveedor;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceProveedorImpl implements ServiceProveedor{
    
    @Autowired
    private RepositoryProveedor repositoryProveedor;

    private ProveedorDTOConverter converter;

    @Override
    public List<ProveedorDTO> getProveedores() {
        List<Proveedor> proveedores = (List<Proveedor>) repositoryProveedor.findAll();
        return proveedores
                .stream()
                .map(proveedor -> converter.convertToDTO(proveedor))
                .toList();
    }
    


}
