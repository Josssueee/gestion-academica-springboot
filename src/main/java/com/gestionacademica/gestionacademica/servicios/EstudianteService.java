package com.gestionacademica.gestionacademica.servicios;

import com.gestionacademica.gestionacademica.dto.EstudianteDTO;
import com.gestionacademica.gestionacademica.entidades.Estudiante;
import com.gestionacademica.gestionacademica.repositorios.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public List<EstudianteDTO> obtenerTodos(String nombre) {
        List<Estudiante> estudiantes;
        if (nombre != null && !nombre.isEmpty()) {
            estudiantes = estudianteRepository.findByNombreEstudianteContainingIgnoreCase(nombre);
        } else {
            estudiantes = estudianteRepository.findAll();
        }
        return estudiantes.stream()
                .map(this::convertirAEstudianteDTO)
                .collect(Collectors.toList());
    }

    public Optional<EstudianteDTO> obtenerPorId(Long id) { // ID como Long
        return estudianteRepository.findById(id)
                .map(this::convertirAEstudianteDTO);
    }

    public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) { // ID como Long
        if (estudianteRepository.existsById(id)) {
            estudiante.setId(id); // Usa .setId()
            return estudianteRepository.save(estudiante);
        }
        return null;
    }

    public void eliminarEstudiante(Long id) { // ID como Long
        estudianteRepository.deleteById(id);
    }

    private EstudianteDTO convertirAEstudianteDTO(Estudiante estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId_estudiante(estudiante.getId()); // Usa .getId()
        dto.setNombre_estudiante(estudiante.getNombreEstudiante()); // Usa el nombre correcto del atributo
        dto.setEmail(estudiante.getEmail());
        if (estudiante.getFechaNacimiento() != null) { // Usa el nombre correcto del atributo
            dto.calcularEdad(estudiante.getFechaNacimiento());
        }
        return dto;
    }
}