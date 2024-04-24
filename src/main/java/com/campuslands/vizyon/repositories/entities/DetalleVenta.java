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
@Table(name = "detalle_venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "IdVentaFk")
    private Venta venta;

    @ManyToOne()
    @JoinColumn(name = "IdProductoFk")
    private Inventario inventario;

    @ManyToOne()
    @JoinColumn(name = "IdTallaFk")
    private Talla talla;

    @Column(nullable = false)
    @NotEmpty(message = "El campo cantidad no puede estar vacío")
    private int cantidad;

    @Column(nullable = false, name = "valor_unit")
    @NotEmpty(message = "El campo valor unitario no puede estar vacío")
    private float valorUnitario;

}
