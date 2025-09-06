package com.gestionacademica.gestionacademica.repositorios;

import com.gestionacademica.gestionacademica.dto.ProfesorCursosDTO;
import com.gestionacademica.gestionacademica.entidades.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    // Método para buscar profesores por nombre (ya existía)
    List<Profesor> findByNombreProfesorContainingIgnoreCase(String nombreProfesor);

    // Nuevo método para el reporte 1: Cuenta el número de cursos por profesor
    @Query("SELECT NEW com.gestionacademica.gestionacademica.dto.ProfesorCursosDTO(p.nombreProfesor, COUNT(c.id)) FROM Profesor p JOIN Curso c ON p.id = c.profesor.id GROUP BY p.nombreProfesor")
    List<ProfesorCursosDTO> contarCursosPorProfesor();
}