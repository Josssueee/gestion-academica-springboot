package com.gestionacademica.gestionacademica.servicios;

import com.gestionacademica.gestionacademica.dto.CursoPromedioDTO;
import com.gestionacademica.gestionacademica.dto.EstudiantesPorCicloDTO;
import com.gestionacademica.gestionacademica.dto.ProfesorCursosDTO;
import com.gestionacademica.gestionacademica.repositorios.EstudianteRepository;
import com.gestionacademica.gestionacademica.repositorios.InscripcionRepository;
import com.gestionacademica.gestionacademica.repositorios.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<ProfesorCursosDTO> getCantidadCursosPorProfesor() {
        return profesorRepository.contarCursosPorProfesor();
    }

    public List<CursoPromedioDTO> getNotaPromedioPorCurso() {
        return inscripcionRepository.calcularPromedioPorCurso();
    }

    public List<EstudiantesPorCicloDTO> getEstudiantesPorCiclo() {
        return estudianteRepository.contarEstudiantesPorCiclo();
    }

    public List<CursoPromedioDTO> getTop3Cursos() {
        return inscripcionRepository.findTop3CursosByPromedio();
    }
}