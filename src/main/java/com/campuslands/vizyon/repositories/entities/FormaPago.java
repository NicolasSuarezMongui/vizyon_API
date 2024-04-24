package com.campuslands.vizyon.repositories.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "forma_pago")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormaPago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "El campo descripcion no puede estar vacío")
    private String descripcion;

    @OneToMany(mappedBy = "formaPago", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venta> ventas;

}
