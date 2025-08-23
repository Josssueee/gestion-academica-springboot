package com.gestionacademica.gestionacademica.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "estudiante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long id;

    @Column(name = "nombre_estudiante", nullable = false)
    private String nombreEstudiante; // O tu nombre de atributo actual

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento; // Asegúrate de que este sea el nombre de tu atributo

    @Column(name = "email", nullable = false, unique = true)
    private String email;

}