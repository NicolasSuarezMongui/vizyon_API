package com.campuslands.vizyon.config;

import java.time.LocalDate;
import java.time.Period;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.vizyon.dtos.EmpleadoDTO;
import com.campuslands.vizyon.repositories.entities.Empleado;

@Component
public class EmpleadoDTOConverter {
    
    @Autowired
    private ModelMapper dbm;

    public EmpleadoDTOConverter(ModelMapper modelMapper){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.dbm = modelMapper;
    }

    public EmpleadoDTO convertToDTO(Empleado empleado){
        EmpleadoDTO dto = dbm.map(empleado, EmpleadoDTO.class);
        if(empleado.getFechaIngreso() != null){
            Period period = Period.between(empleado.getFechaIngreso().toLocalDate(), LocalDate.now());
            int diff = period.getYears();
            dto.setCantidad(diff);
        }
        if(empleado.getVentas() != null){
            dto.setCantidadVentas(empleado.getVentas().size());
        }
        if(empleado.getCargo() != null){
            dto.setIdCargo(empleado.getCargo().getId());
            dto.setCargoDescripcion(empleado.getCargo().getDescripcion());
        }
        if(empleado.getMunicipio() != null){
            dto.setIdMunicipio(empleado.getMunicipio().getId());
            dto.setMunicipioNombre(empleado.getMunicipio().getNombre());
        }
        return dto;
    }

    public Empleado convertToEntity(EmpleadoDTO empleadoDTO){
        return dbm.map(empleadoDTO, Empleado.class);
    }

}
