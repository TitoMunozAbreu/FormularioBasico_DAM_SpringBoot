package com.example.formulariobasicoalumno_spring.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlumno;
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;

}
