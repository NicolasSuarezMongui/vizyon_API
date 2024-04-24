package com.campuslands.vizyon.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.vizyon.dtos.EmpleadoDTO;
import com.campuslands.vizyon.services.ServiceEmpleado;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/empleado")
@AllArgsConstructor
public class EmpleadoController {
    
    private ServiceEmpleado serviceEmpleado;

    @GetMapping
    @JsonView(EmpleadoDTO.class)
    public ResponseEntity<List<EmpleadoDTO>> getEmpleados() {
        List<EmpleadoDTO> empleados = serviceEmpleado.getEmpleados();
        if (empleados.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(empleados);
            
        }
    }

    @GetMapping("/ordenados")
    @JsonView(EmpleadoDTO.class)
    public ResponseEntity<List<EmpleadoDTO>> getEmpleadosOrderedByDate() {
        List<EmpleadoDTO> empleados = serviceEmpleado.getEmpleadosOrderedByDate();
        if (empleados.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(empleados);
        }
    }

}
