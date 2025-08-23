package com.gestionacademica.gestionacademica.repositorios;

import com.gestionacademica.gestionacademica.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findByNombreEstudianteContainingIgnoreCase(String nombreEstudiante);
}