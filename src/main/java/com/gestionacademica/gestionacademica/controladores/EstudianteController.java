package com.gestionacademica.gestionacademica.controladores;

import com.gestionacademica.gestionacademica.dto.EstudianteDTO;
import com.gestionacademica.gestionacademica.entidades.Estudiante;
import com.gestionacademica.gestionacademica.servicios.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.guardarEstudiante(estudiante);
        return ResponseEntity.ok(nuevoEstudiante);
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> obtenerTodos(@RequestParam(required = false) String nombre) {
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodos(nombre);
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> obtenerPorId(@PathVariable Long id) { // ID como Long
        return estudianteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) { // ID como Long
        Estudiante estudianteActualizado = estudianteService.actualizarEstudiante(id, estudiante);
        if (estudianteActualizado != null) {
            return ResponseEntity.ok(estudianteActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) { // ID como Long
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}