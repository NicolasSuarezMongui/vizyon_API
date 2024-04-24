package com.campuslands.vizyon.repositories.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo fecha no puede estar vacío")
    @Column(nullable = false, name = "Fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @ManyToOne()
    @JoinColumn(name = "IdEmpleadoFk")
    private Empleado empleado;

    @ManyToOne()
    @JoinColumn(name = "IdClienteFk")
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "IdFormaPagoFk")
    private FormaPago formaPago;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalleVenta;

}
