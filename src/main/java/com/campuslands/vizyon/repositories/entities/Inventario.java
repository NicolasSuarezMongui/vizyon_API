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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo código inventario no puede estar vacío")
    @Column(name = "CodInv", nullable = false)
    private String codigoInventario;

    @ManyToOne()
    @JoinColumn(name = "IdPrendaFk")
    private Prenda prenda;

    @NotEmpty(message = "El campo valor venta COP no puede estar vacío")
    @Column(name = "ValorVtaCop", nullable = false)
    private float valorVentaCop;

    @NotEmpty(message = "El campo valor venta USD no puede estar vacío")
    @Column(name = "ValorVtaUsd", nullable = false)
    private float valorVentaUsd;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalleVenta;

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(
        name = "inventario_talla",
        joinColumns = @JoinColumn(name = "IdInvFk"),
        inverseJoinColumns = @JoinColumn(name = "IdTallaFk")
    )
    private List<Talla> tallas;

}
