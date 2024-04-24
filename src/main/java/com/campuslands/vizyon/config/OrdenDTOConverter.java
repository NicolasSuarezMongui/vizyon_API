package com.campuslands.vizyon.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.vizyon.dtos.OrdenDTO;
import com.campuslands.vizyon.repositories.entities.Orden;

@Component
public class OrdenDTOConverter {
    
    @Autowired
    private ModelMapper dbm;

    public OrdenDTOConverter(ModelMapper modelMapper){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.dbm = modelMapper;
    }

    public OrdenDTO convertToDTO(Orden orden){
        OrdenDTO dto = dbm.map(orden, OrdenDTO.class);
        if(orden.getEmpleado() != null){
            dto.setIdEmpleado(orden.getEmpleado().getId());
            dto.setEmpleadoNombre(orden.getEmpleado().getNombre());
        }
        if(orden.getCliente() != null){
            dto.setIdCliente(orden.getCliente().getId());
            dto.setClienteNombre(orden.getCliente().getNombre());
        }
        if(orden.getEstado() != null){
            dto.setIdEstado(orden.getEstado().getId());
            dto.setEstadoDescripcion(orden.getEstado().getDescripcion());
        }
        return dto;
    }

    public Orden convertToEntity(OrdenDTO ordenDTO){
        return dbm.map(ordenDTO, Orden.class);
    }

}
