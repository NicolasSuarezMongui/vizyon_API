package com.campuslands.vizyon.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    
    @JsonView(VentaDTO.class)
    private Long id;

    @JsonView(VentaDTO.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    private Long idEmpleado;
    @JsonView(VentaDTO.class)
    private String empleadoNombre;

    private Long idCliente;
    @JsonView(VentaDTO.class)
    private String clienteNombre;

    private Long idFormaPago;
    @JsonView(VentaDTO.class)
    private String formaPagoDescripcion;

}
