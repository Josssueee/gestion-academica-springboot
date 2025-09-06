package com.gestionacademica.gestionacademica.repositorios;

import com.gestionacademica.gestionacademica.dto.EstudiantesPorCicloDTO;
import com.gestionacademica.gestionacademica.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    // Método para buscar estudiantes por nombre (ya existía)
    List<Estudiante> findByNombreEstudianteContainingIgnoreCase(String nombreEstudiante);

    // Nuevo método para el reporte 3: Cuenta la cantidad de estudiantes por ciclo.
    @Query("SELECT NEW com.gestionacademica.gestionacademica.dto.EstudiantesPorCicloDTO(YEAR(e.fechaNacimiento), COUNT(e.id)) FROM Estudiante e GROUP BY YEAR(e.fechaNacimiento) ORDER BY YEAR(e.fechaNacimiento)")
    List<EstudiantesPorCicloDTO> contarEstudiantesPorCiclo();
}