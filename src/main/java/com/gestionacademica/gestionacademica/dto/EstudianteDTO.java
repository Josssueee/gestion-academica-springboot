package com.gestionacademica.gestionacademica.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.Period;

@Data
public class EstudianteDTO {
    private Long id_estudiante;
    private String nombre_estudiante;
    private String email;
    private Integer edad;

    public void calcularEdad(LocalDate fechaNacimiento) {
        if (fechaNacimiento != null) {
            this.edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        }
    }
}