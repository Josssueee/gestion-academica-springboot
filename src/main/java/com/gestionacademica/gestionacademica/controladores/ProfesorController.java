package com.gestionacademica.gestionacademica.controladores;

import com.gestionacademica.gestionacademica.dto.ProfesorDTO;
import com.gestionacademica.gestionacademica.entidades.Profesor;
import com.gestionacademica.gestionacademica.servicios.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
        Profesor nuevoProfesor = profesorService.guardarProfesor(profesor);
        return ResponseEntity.ok(nuevoProfesor);
    }

    @GetMapping
    public ResponseEntity<List<ProfesorDTO>> obtenerTodos(@RequestParam(required = false) String nombre) {
        List<ProfesorDTO> profesores = profesorService.obtenerTodos(nombre);
        return ResponseEntity.ok(profesores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> obtenerPorId(@PathVariable Long id) {
        return profesorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        Profesor profesorActualizado = profesorService.actualizarProfesor(id, profesor);
        if (profesorActualizado != null) {
            return ResponseEntity.ok(profesorActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Long id) {
        profesorService.eliminarProfesor(id);
        return ResponseEntity.noContent().build();
    }
}