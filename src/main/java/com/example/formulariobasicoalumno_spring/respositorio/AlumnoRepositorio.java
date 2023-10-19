package com.example.formulariobasicoalumno_spring.respositorio;

import com.example.formulariobasicoalumno_spring.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno,Integer> {

}
