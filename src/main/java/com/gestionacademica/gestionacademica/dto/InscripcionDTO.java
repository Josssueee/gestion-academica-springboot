package com.gestionacademica.gestionacademica.dto;

import lombok.Data;

@Data
public class InscripcionDTO {
    private Long idInscripcion;
    private String nombreEstudiante;
    private String nombreCurso;
    private Double calificacion;
}