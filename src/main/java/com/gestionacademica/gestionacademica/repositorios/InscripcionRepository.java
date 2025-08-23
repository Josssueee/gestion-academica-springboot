package com.gestionacademica.gestionacademica.repositorios;

import com.gestionacademica.gestionacademica.entidades.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByEstudiante_Id(Long idEstudiante);
}