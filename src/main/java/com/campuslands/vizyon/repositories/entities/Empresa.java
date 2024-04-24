package com.campuslands.vizyon.repositories.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empresa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "El campo NIT no puede estar vacío")
    private String nit;

    @Column(nullable = false, name = "razon_social")
    @NotEmpty(message = "El campo razón social no puede estar vacío")
    private String razonSocial;

    @Column(nullable = false, name = "representante_legal")
    @NotEmpty(message = "El campo representante legal no puede estar vacío")
    private String representante;

    @Column(nullable = false, name = "FechaCreacion")
    @NotEmpty(message = "El campo fecha de creación no puede estar vacío")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaCreacion;

    @ManyToOne()
    @JoinColumn(name = "IdMunicipioFk")
    private Municipio municipio;

}
