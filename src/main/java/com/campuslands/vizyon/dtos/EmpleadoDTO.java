package com.campuslands.vizyon.dtos;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    
    @JsonView(EmpleadoDTO.class)
    private Long id;

    @JsonView(EmpleadoDTO.class)
    private String nombre;

    private Long idCargo;
    @JsonView(EmpleadoDTO.class)
    private String cargoDescripcion;

    private Long idMunicipio;
    @JsonView(EmpleadoDTO.class)
    private String municipioNombre;

    @JsonView(EmpleadoDTO.class)
    private Integer cantidad;

    @JsonView(EmpleadoDTO.class)
    private int cantidadVentas;


}
