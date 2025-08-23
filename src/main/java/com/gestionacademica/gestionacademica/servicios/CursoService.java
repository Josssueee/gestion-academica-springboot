package com.gestionacademica.gestionacademica.servicios;

import com.gestionacademica.gestionacademica.dto.CursoDTO;
import com.gestionacademica.gestionacademica.entidades.Curso;
import com.gestionacademica.gestionacademica.repositorios.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<CursoDTO> obtenerTodos(String nombre) {
        List<Curso> cursos;
        if (nombre != null && !nombre.isEmpty()) {
            cursos = cursoRepository.findByNombreContainingIgnoreCase(nombre);
        } else {
            cursos = cursoRepository.findAll();
        }
        return cursos.stream()
                .map(this::convertirACursoDTO)
                .collect(Collectors.toList());
    }

    public Optional<CursoDTO> obtenerPorId(Long id) {
        return cursoRepository.findById(id)
                .map(this::convertirACursoDTO);
    }

    public Curso actualizarCurso(Long id, Curso curso) {
        if (cursoRepository.existsById(id)) {
            curso.setId(id);
            return cursoRepository.save(curso);
        }
        return null;
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    private CursoDTO convertirACursoDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId_curso(curso.getId());
        dto.setNombre_curso(curso.getNombre());
        dto.setDescripcion(curso.getDescripcion());
        return dto;
    }
}