package com.campuslands.vizyon.dtos;

import java.util.List;

import com.campuslands.vizyon.repositories.entities.Insumo;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDTO {
    
    @JsonView(ProveedorDTO.class)
    private Long id;

    @JsonView(ProveedorDTO.class)
    private String nit;

    @JsonView(ProveedorDTO.class)
    private String nombre;

    private Long idTipoPersona;
    private String tipoPersona;

    private Long idMunicipio;
    private String municipio;

    @JsonView(ProveedorDTO.class)
    private List<Insumo> insumos;

}
