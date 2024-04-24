package com.campuslands.vizyon.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.vizyon.dtos.VentaDTO;
import com.campuslands.vizyon.repositories.entities.Venta;

@Component
public class VentaDTOConverter {
    
    @Autowired
    private ModelMapper dbm;

    public VentaDTOConverter(ModelMapper modelMapper){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.dbm = modelMapper;
    }

    public VentaDTO convertToDTO(Venta venta){
        VentaDTO dto = dbm.map(venta, VentaDTO.class);
        if(venta.getEmpleado() != null){
            dto.setIdEmpleado(venta.getEmpleado().getId());
            dto.setEmpleadoNombre(venta.getEmpleado().getNombre());
        }
        if(venta.getCliente() != null){
            dto.setIdCliente(venta.getCliente().getId());
            dto.setClienteNombre(venta.getCliente().getNombre());
        }
        if(venta.getFormaPago() != null){
            dto.setIdFormaPago(venta.getFormaPago().getId());
            dto.setFormaPagoDescripcion(venta.getFormaPago().getDescripcion());
        }
        return dto;
    }

    public Venta convertToEntity(VentaDTO ventaDTO){
        return dbm.map(ventaDTO, Venta.class);
    }

}
