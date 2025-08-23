package com.gestionacademica.gestionacademica.servicios;

import com.gestionacademica.gestionacademica.dto.InscripcionDTO;
import com.gestionacademica.gestionacademica.entidades.Curso;
import com.gestionacademica.gestionacademica.entidades.Estudiante;
import com.gestionacademica.gestionacademica.entidades.Inscripcion;
import com.gestionacademica.gestionacademica.repositorios.CursoRepository;
import com.gestionacademica.gestionacademica.repositorios.EstudianteRepository;
import com.gestionacademica.gestionacademica.repositorios.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Inscripcion guardarInscripcion(Long idEstudiante, Long idCurso) {
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(idEstudiante);
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);

        if (estudianteOptional.isPresent() && cursoOptional.isPresent()) {
            Inscripcion nuevaInscripcion = new Inscripcion();
            nuevaInscripcion.setEstudiante(estudianteOptional.get());
            nuevaInscripcion.setCurso(cursoOptional.get());
            nuevaInscripcion.setFechaInscripcion(LocalDate.now());
            return inscripcionRepository.save(nuevaInscripcion);
        }
        return null;
    }

    public List<InscripcionDTO> obtenerTodas() {
        return inscripcionRepository.findAll().stream()
                .map(this::convertirAInscripcionDTO)
                .collect(Collectors.toList());
    }

    public Optional<InscripcionDTO> obtenerPorId(Long id) {
        return inscripcionRepository.findById(id)
                .map(this::convertirAInscripcionDTO);
    }
    
    // Método para filtrar inscripciones
    public List<InscripcionDTO> obtenerInscripcionesPorEstudiante(Long idEstudiante) {
        return inscripcionRepository.findByEstudiante_Id(idEstudiante).stream()
                .map(this::convertirAInscripcionDTO)
                .collect(Collectors.toList());
    }

    public Inscripcion actualizarInscripcion(Long id, Inscripcion inscripcionActualizada) {
        if (inscripcionRepository.existsById(id)) {
            inscripcionActualizada.setIdInscripcion(id);
            return inscripcionRepository.save(inscripcionActualizada);
        }
        return null;
    }

    public void eliminarInscripcion(Long id) {
        inscripcionRepository.deleteById(id);
    }

    private InscripcionDTO convertirAInscripcionDTO(Inscripcion inscripcion) {
        InscripcionDTO dto = new InscripcionDTO();
        dto.setIdInscripcion(inscripcion.getIdInscripcion());
        dto.setNombreEstudiante(inscripcion.getEstudiante().getNombreEstudiante());
        dto.setNombreCurso(inscripcion.getCurso().getNombre());
        dto.setCalificacion(inscripcion.getCalificacion());
        return dto;
    }
}