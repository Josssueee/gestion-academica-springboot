package com.gestionacademica.gestionacademica.repositorios;

import com.gestionacademica.gestionacademica.entidades.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    List<Profesor> findByNombreProfesorContainingIgnoreCase(String nombreProfesor);
}