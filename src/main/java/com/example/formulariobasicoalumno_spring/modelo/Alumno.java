package com.example.formulariobasicoalumno_spring.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "Ingresar nombre")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Ingresar nombre con solo caracteres")
    private String nombre;

    @NotBlank(message = "Ingresar apellido")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Ingresar apellido con solo caracteres")
    private String apellido;

    @NotNull(message = "Ingresar edad")
    @Positive(message = "Ingresar una edad valida")
    @Digits(integer = 2,fraction = 0,message = "Edad valida entre 1 - 99 años")
    private int edad;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,9}[A-Za-z]$", message = "ID validos, ejemplos: DNI 12345678A | NIE X12345678A")
    private String dni;

}
