package com.campuslands.vizyon.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenDTO {

    @JsonView(OrdenDTO.class)
    private Long id;
    
    @JsonView(OrdenDTO.class)
    private Date fecha;

    private Long idEmpleado;
    @JsonView(OrdenDTO.class)
    private String empleadoNombre;

    private Long idCliente;
    @JsonView(OrdenDTO.class)
    private String clienteNombre;

    private Long idEstado;
    @JsonView(OrdenDTO.class)
    private String estadoDescripcion;
}
