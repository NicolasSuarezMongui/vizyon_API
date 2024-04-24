package com.campuslands.vizyon.repositories;
import com.campuslands.vizyon.repositories.entities.Empleado;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface RepositoryEmpleado extends CrudRepository<Empleado, Long> {

    List<Empleado> findAllByOrderByFechaIngresoDesc();

}