package com.campuslands.vizyon.repositories.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "NitProveedor")
    @NotEmpty(message = "El campo NIT no puede estar vacío")
    private String nit;

    @Column(nullable = false, name = "Nombre")
    @NotEmpty(message = "El campo nombre no puede estar vacío")
    private String nombre;

    @ManyToOne()
    @JoinColumn(name = "IdTipoPersona")
    private TipoPersona tipoPersona;

    @ManyToOne()
    @JoinColumn(name = "IdMunicipioFk")
    private Municipio municipio;

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(
        name = "insumo_proveedor",
        joinColumns = @JoinColumn(name = "IdProveedorFk"),
        inverseJoinColumns = @JoinColumn(name = "IdInsumoFk")
    )
    private List<Insumo> insumos;
}
