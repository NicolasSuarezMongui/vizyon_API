package com.campuslands.vizyon.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.vizyon.dtos.ProveedorDTO;
import com.campuslands.vizyon.repositories.entities.Proveedor;

@Component
public class ProveedorDTOConverter {
    
    @Autowired
    private ModelMapper dbm;

    public ProveedorDTOConverter(ModelMapper modelMapper){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.dbm = modelMapper;
    }

    public ProveedorDTO convertToDTO(Proveedor proveedor){
        ProveedorDTO dto = dbm.map(proveedor, ProveedorDTO.class);
        if(proveedor.getTipoPersona() != null){
            dto.setIdTipoPersona(proveedor.getTipoPersona().getId());
            dto.setTipoPersona(proveedor.getTipoPersona().getNombre());
        }
        if(proveedor.getMunicipio() != null){
            dto.setIdMunicipio(proveedor.getMunicipio().getId());
            dto.setMunicipio(proveedor.getMunicipio().getNombre());
        }
        return dto;
    }

    public Proveedor convertToEntity(ProveedorDTO proveedorDTO){
        return dbm.map(proveedorDTO, Proveedor.class);
    }

}
