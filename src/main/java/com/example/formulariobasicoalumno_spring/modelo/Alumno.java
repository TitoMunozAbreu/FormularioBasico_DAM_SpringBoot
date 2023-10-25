package com.example.formulariobasicoalumno_spring.modelo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@Table(name = "alumno")
@NamedStoredProcedureQuery(
        name = "eliminarAlumno",
        procedureName = "eliminarAlumnoPorID",
        parameters = {
                @StoredProcedureParameter(
                        mode = ParameterMode.IN,
                        name = "idAlumno",
                        type = Integer.class)
        }
)
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlumno;
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;

}
