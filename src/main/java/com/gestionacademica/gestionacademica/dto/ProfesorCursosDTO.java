package com.gestionacademica.gestionacademica.dto;

import lombok.Data;

@Data
public class ProfesorCursosDTO {
    private String nombreProfesor;
    private Long cantidadCursos;

    public ProfesorCursosDTO(String nombreProfesor, Long cantidadCursos) {
        this.nombreProfesor = nombreProfesor;
        this.cantidadCursos = cantidadCursos;
    }
}