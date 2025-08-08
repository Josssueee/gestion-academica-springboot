package com.gestionacademica.gestionacademica.servicios;

import com.gestionacademica.gestionacademica.entidades.Curso;
import com.gestionacademica.gestionacademica.repositorios.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    // Crear un nuevo curso
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Obtener todos los cursos
    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    // Obtener un curso por su ID
    public Optional<Curso> obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    // Actualizar un curso existente
    public Curso actualizarCurso(Long id, Curso cursoActualizado) {
        if (cursoRepository.existsById(id)) {
            cursoActualizado.setId(id);
            return cursoRepository.save(cursoActualizado);
        }
        return null;
    }

    // Eliminar un curso por su ID
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
