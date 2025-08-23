package com.gestionacademica.gestionacademica.controladores;

import com.gestionacademica.gestionacademica.dto.CursoDTO;
import com.gestionacademica.gestionacademica.entidades.Curso;
import com.gestionacademica.gestionacademica.servicios.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.guardarCurso(curso);
        return ResponseEntity.ok(nuevoCurso);
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> obtenerTodos(@RequestParam(required = false) String nombre) {
        List<CursoDTO> cursos = cursoService.obtenerTodos(nombre);
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtenerPorId(@PathVariable Long id) {
        return cursoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        Curso cursoActualizado = cursoService.actualizarCurso(id, curso);
        if (cursoActualizado != null) {
            return ResponseEntity.ok(cursoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }
}