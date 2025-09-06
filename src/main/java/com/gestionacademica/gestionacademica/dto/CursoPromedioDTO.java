package com.gestionacademica.gestionacademica.dto;

import lombok.Data;

@Data
public class CursoPromedioDTO {
    private String nombreCurso;
    private Double promedio;

    public CursoPromedioDTO(String nombreCurso, Double promedio) {
        this.nombreCurso = nombreCurso;
        this.promedio = promedio;
    }
}