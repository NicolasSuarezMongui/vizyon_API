package com.campuslands.vizyon.repositories;
import com.campuslands.vizyon.repositories.entities.Cliente;
import org.springframework.data.repository.CrudRepository;
public interface RepositoryCliente extends CrudRepository<Cliente, Long> {}