package com.gestionacademica.gestionacademica.servicios;

import com.gestionacademica.gestionacademica.entidades.Estudiante;
import com.gestionacademica.gestionacademica.repositorios.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // Crear un nuevo estudiante
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // Obtener todos los estudiantes
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    // Obtener un estudiante por su ID
    public Optional<Estudiante> obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id);
    }

    // Actualizar un estudiante existente
    public Estudiante actualizarEstudiante(Long id, Estudiante estudianteActualizado) {
        if (estudianteRepository.existsById(id)) {
            estudianteActualizado.setId(id);
            return estudianteRepository.save(estudianteActualizado);
        }
        return null;
    }

    // Eliminar un estudiante por su ID
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}