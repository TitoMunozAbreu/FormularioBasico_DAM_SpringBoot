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

    public void actualizarAlumnoPorID(int idAlumno, Alumno alumnoActualizado) {
        Alumno alumnoEncontrado = this.alumnoRepositorio.findById(idAlumno)
                .orElseThrow(() -> new IllegalArgumentException("Id invalido de alumno: " + idAlumno));

        //actualizar datos del alumno
        alumnoEncontrado.setNombre(alumnoActualizado.getNombre());
        alumnoEncontrado.setApellido(alumnoActualizado.getApellido());
        alumnoEncontrado.setEdad(alumnoActualizado.getEdad());
        alumnoEncontrado.setDni(alumnoEncontrado.getDni());

        //guardar cambios en la BBDD
        this.alumnoRepositorio.save(alumnoEncontrado);
/*        this.alumnoRepositorio.actualizarAlumnoPorID(
                alumnoActualizado.getNombre(),
                alumnoActualizado.getApellido(),
                alumnoActualizado.getEdad(),
                alumnoActualizado.getDni(),
                idAlumno);*/

    }

    public Alumno buscarAlumnoPorID(int idAlumno) {
        return this.alumnoRepositorio.findById(idAlumno)
                .orElseThrow(() -> new IllegalArgumentException("Id invalido de alumno: " + idAlumno ));
    }

    public void eliminarAlumnoPorID(int idAlumno) {
        this.alumnoRepositorio.deleteById(idAlumno);
    }
}
