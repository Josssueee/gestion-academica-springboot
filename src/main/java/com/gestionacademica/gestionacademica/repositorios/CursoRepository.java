package com.gestionacademica.gestionacademica.repositorios;

import com.gestionacademica.gestionacademica.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}