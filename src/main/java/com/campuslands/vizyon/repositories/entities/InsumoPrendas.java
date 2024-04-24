package com.campuslands.vizyon.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "insumo_prendas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsumoPrendas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "IdInsumoFk")
    private Insumo insumo;

    @ManyToOne()
    @JoinColumn(name = "IdPrendaFk")
    private Prenda prenda;

    @Column(nullable = false, name = "Cantidad")
    private int cantidad;
}
