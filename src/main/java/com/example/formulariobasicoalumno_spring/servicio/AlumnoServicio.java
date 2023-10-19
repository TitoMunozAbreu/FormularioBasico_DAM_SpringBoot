package com.example.formulariobasicoalumno_spring.servicio;

import com.example.formulariobasicoalumno_spring.modelo.Alumno;
import com.example.formulariobasicoalumno_spring.respositorio.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServicio {

    @Autowired
    private AlumnoRepositorio alumnoRepositorio;


    public List<Alumno> mostrarAlumnos() {
        return this.alumnoRepositorio.findAll();
    }

    public void crearAlumno(Alumno nuevoAlumno) {
        this.alumnoRepositorio.save(nuevoAlumno);
    }
}
