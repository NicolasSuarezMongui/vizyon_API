package com.campuslands.vizyon.repositories.entities;

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
@Table(name = "detalle_orden")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleOrden {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "IdOrdenFk")
    private Orden orden;

    @ManyToOne()
    @JoinColumn(name = "IdPrendaFk")
    private Prenda prenda;

    @Column(nullable = false, name = "cantidad_producir")
    @NotEmpty(message = "El campo cantidad a producir no puede estar vacío")
    private int cantidadProduccion;

    @ManyToOne()
    @JoinColumn(name = "IdColorFk")
    private Color color;

    @Column(nullable = false, name = "cantidad_producida")
    @NotEmpty(message = "El campo cantidad producida no puede estar vacío")
    private int cantidadProducida;

    @ManyToOne()
    @JoinColumn(name = "IdEstadoFk")
    private Estado estado;
}
