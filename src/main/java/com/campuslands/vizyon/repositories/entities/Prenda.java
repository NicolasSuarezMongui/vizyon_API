package com.campuslands.vizyon.repositories.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prenda")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prenda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo nombre no puede estar vacío")
    @Column(nullable = false, name = "Nombre")
    private String nombre;

    @Column(nullable = false, name = "ValorUnitCop")
    @NotEmpty(message = "El campo valor unitario cop no puede estar vacío")
    private float valorUnitarioCop;

    @Column(nullable = false, name = "ValorUnitUsd")
    @NotEmpty(message = "El campo valor unitario usd no puede estar vacío")
    private float valorUnitarioUsd;

    @ManyToOne()
    @JoinColumn(name = "IdEstadoFk")    
    private Estado estado;

    @ManyToOne()
    @JoinColumn(name = "IdTipoProteccionFk")
    private TipoProteccion tipoProteccion;

    @ManyToOne()
    @JoinColumn(name = "IdGeneroFk")
    private Genero genero;

    @NotEmpty(message = "El campo codigo no puede estar vacío")
    @Column(nullable = false, name = "Codigo")
    private String codigo;

    @OneToMany(mappedBy = "prenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventario> inventarios;

    @OneToMany(mappedBy = "prenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleOrden> detalleOrdenes;

    @OneToMany(mappedBy = "prenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InsumoPrendas> insumoPrendas;

}
