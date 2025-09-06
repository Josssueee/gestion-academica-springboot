package com.gestionacademica.gestionacademica.repositorios;

import com.gestionacademica.gestionacademica.dto.CursoPromedioDTO;
import com.gestionacademica.gestionacademica.entidades.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    // Método para buscar inscripciones por estudiante (ya existía)
    List<Inscripcion> findByEstudiante_Id(Long idEstudiante);

    // Nuevo método para el reporte 2: Calcula la nota promedio por curso
    @Query("SELECT NEW com.gestionacademica.gestionacademica.dto.CursoPromedioDTO(i.curso.nombre, AVG(i.calificacion)) FROM Inscripcion i WHERE i.calificacion IS NOT NULL GROUP BY i.curso.nombre")
    List<CursoPromedioDTO> calcularPromedioPorCurso();

    // Nuevo método para el reporte 4: Muestra los 3 cursos con la nota promedio más alta
    @Query("SELECT NEW com.gestionacademica.gestionacademica.dto.CursoPromedioDTO(i.curso.nombre, AVG(i.calificacion)) FROM Inscripcion i WHERE i.calificacion IS NOT NULL GROUP BY i.curso.nombre ORDER BY AVG(i.calificacion) DESC LIMIT 3")
    List<CursoPromedioDTO> findTop3CursosByPromedio();
}