package com.campuslands.vizyon.repositories.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "insumo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insumo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "El campo nombre no puede estar vacío")
    private String nombre;

    @Column(nullable = false, name = "valor_unit")
    @NotEmpty(message = "El campo valor unitario no puede estar vacío")
    private float valorUnitario;

    @Column(nullable = false, name = "stock_min")
    @NotEmpty(message = "El campo stock mínimo no puede estar vacío")
    private float stockMinimo;

    @Column(nullable = false, name = "stock_max")
    @NotEmpty(message = "El campo stock máximo no puede estar vacío")
    private float stockMaximo;

    @OneToMany(mappedBy = "insumo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InsumoPrendas> insumoPrendas;

    @ManyToMany(mappedBy = "insumos")
    private List<Proveedor> proveedores;

}
