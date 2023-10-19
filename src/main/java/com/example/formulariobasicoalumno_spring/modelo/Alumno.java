package com.example.formulariobasicoalumno_spring.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAlumno;
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;

}
