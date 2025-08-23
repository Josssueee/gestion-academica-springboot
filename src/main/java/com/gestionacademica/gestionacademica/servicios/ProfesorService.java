package com.gestionacademica.gestionacademica.servicios;

import com.gestionacademica.gestionacademica.dto.ProfesorDTO;
import com.gestionacademica.gestionacademica.entidades.Profesor;
import com.gestionacademica.gestionacademica.repositorios.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor guardarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public List<ProfesorDTO> obtenerTodos(String nombre) {
        List<Profesor> profesores;
        if (nombre != null && !nombre.isEmpty()) {
            profesores = profesorRepository.findByNombreProfesorContainingIgnoreCase(nombre);
        } else {
            profesores = profesorRepository.findAll();
        }
        return profesores.stream()
                .map(this::convertirAProfesorDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProfesorDTO> obtenerPorId(Long id) {
        return profesorRepository.findById(id)
                .map(this::convertirAProfesorDTO);
    }

    public Profesor actualizarProfesor(Long id, Profesor profesor) {
        if (profesorRepository.existsById(id)) {
            profesor.setId(id);
            return profesorRepository.save(profesor);
        }
        return null;
    }

    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }

    private ProfesorDTO convertirAProfesorDTO(Profesor profesor) {
        ProfesorDTO dto = new ProfesorDTO();
        dto.setIdProfesor(profesor.getId());
        dto.setNombreProfesor(profesor.getNombreProfesor());
        return dto;
    }
}