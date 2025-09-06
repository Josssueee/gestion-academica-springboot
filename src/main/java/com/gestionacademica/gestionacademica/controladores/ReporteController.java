package com.gestionacademica.gestionacademica.controladores;

import com.gestionacademica.gestionacademica.dto.CursoPromedioDTO;
import com.gestionacademica.gestionacademica.dto.EstudiantesPorCicloDTO;
import com.gestionacademica.gestionacademica.dto.ProfesorCursosDTO;
import com.gestionacademica.gestionacademica.servicios.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/cursos-por-profesor")
    public ResponseEntity<List<ProfesorCursosDTO>> getCursosPorProfesor() {
        return ResponseEntity.ok(reporteService.getCantidadCursosPorProfesor());
    }

    @GetMapping("/promedio-por-curso")
    public ResponseEntity<List<CursoPromedioDTO>> getNotaPromedioPorCurso() {
        return ResponseEntity.ok(reporteService.getNotaPromedioPorCurso());
    }

    @GetMapping("/estudiantes-por-ciclo")
    public ResponseEntity<List<EstudiantesPorCicloDTO>> getEstudiantesPorCiclo() {
        return ResponseEntity.ok(reporteService.getEstudiantesPorCiclo());
    }

    @GetMapping("/top-3-cursos")
    public ResponseEntity<List<CursoPromedioDTO>> getTop3Cursos() {
        return ResponseEntity.ok(reporteService.getTop3Cursos());
    }
}