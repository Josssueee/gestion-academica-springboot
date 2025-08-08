package com.gestionacademica.gestionacademica.servicios;

import com.gestionacademica.gestionacademica.entidades.Profesor;
import com.gestionacademica.gestionacademica.repositorios.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor guardarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public List<Profesor> obtenerTodosLosProfesores() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> obtenerProfesorPorId(Long id) {
        return profesorRepository.findById(id);
    }

    public Profesor actualizarProfesor(Long id, Profesor profesorActualizado) {
        if (profesorRepository.existsById(id)) {
            profesorActualizado.setId(id);
            return profesorRepository.save(profesorActualizado);
        }
        return null;
    }

    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }
}
