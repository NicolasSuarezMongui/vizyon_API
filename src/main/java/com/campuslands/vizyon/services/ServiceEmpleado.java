package com.campuslands.vizyon.services;

import java.util.List;

import com.campuslands.vizyon.dtos.EmpleadoDTO;

public interface ServiceEmpleado {
    
    List<EmpleadoDTO> getEmpleados();

    List<EmpleadoDTO> getEmpleadosOrderedByDate();

}
