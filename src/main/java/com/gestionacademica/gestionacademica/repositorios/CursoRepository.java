package com.gestionacademica.gestionacademica.repositorios;

import com.gestionacademica.gestionacademica.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByNombreContainingIgnoreCase(String nombre);
}