package com.campuslands.vizyon.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.vizyon.dtos.VentaDTO;
import com.campuslands.vizyon.services.ServiceVenta;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/venta")
@AllArgsConstructor
public class VentaController {
    
    private ServiceVenta serviceVenta;

    @GetMapping
    @JsonView(VentaDTO.class)
    public ResponseEntity<List<VentaDTO>> getAllVentas() {
        List<VentaDTO> ventas = serviceVenta.getVentas();
        if (ventas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(ventas);
        }
    }

    @GetMapping("/mesanho")
    @JsonView(VentaDTO.class)
    public ResponseEntity<List<VentaDTO>> getVentasByMonthAndYear(@RequestParam int month, @RequestParam int year) {
        List<VentaDTO> ventas = serviceVenta.getVentasByMonthAndYear(month-1, year);
        if (ventas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(ventas);
        }
    }

}
