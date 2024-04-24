package com.campuslands.vizyon.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.vizyon.config.EmpleadoDTOConverter;
import com.campuslands.vizyon.dtos.EmpleadoDTO;
import com.campuslands.vizyon.repositories.RepositoryEmpleado;
import com.campuslands.vizyon.repositories.entities.Empleado;
import com.campuslands.vizyon.services.ServiceEmpleado;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceEmpleadoImpl implements ServiceEmpleado{

    @Autowired
    private RepositoryEmpleado repositoryEmpleado;

    @Autowired
    private EmpleadoDTOConverter converter;

    @Override
    @Transactional(readOnly = true)
    public List<EmpleadoDTO> getEmpleados() {
        List<Empleado> empleados = (List<Empleado>) repositoryEmpleado.findAll();
        return empleados.stream()
                .map(empleado -> converter.convertToDTO(empleado))
                .toList();
    }

    @Override
    public List<EmpleadoDTO> getEmpleadosOrderedByDate() {
        List<Empleado> empleados = repositoryEmpleado.findAllByOrderByFechaIngresoDesc();
        return empleados.stream()
                .map(empleado -> converter.convertToDTO(empleado))
                .toList();
    }
    


}
