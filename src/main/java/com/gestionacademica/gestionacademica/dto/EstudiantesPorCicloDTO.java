package com.gestionacademica.gestionacademica.dto;

import lombok.Data;

@Data
public class EstudiantesPorCicloDTO {
    private Integer ciclo;
    private Long cantidadEstudiantes;

    public EstudiantesPorCicloDTO(Integer ciclo, Long cantidadEstudiantes) {
        this.ciclo = ciclo;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }
}