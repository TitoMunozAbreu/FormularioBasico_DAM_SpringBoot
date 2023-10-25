package com.example.formulariobasicoalumno_spring.respositorio;

import com.example.formulariobasicoalumno_spring.modelo.Alumno;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno,Integer> {

/*    @Modifying
    @Query("UPDATE alumno A SET A.nombre = :nombre, A.apellido = :apellido, A.edad = :edad, A.dni = :dni WHERE A.id_alumno = :idAlumno")
    int actualizarAlumnoPorID(
            @Param("nombre") String nombre,
            @Param("apellido") String apellido,
            @Param("edad") int edad,
            @Param("dni") String dni,
            @Param("idAlumno") int idAlumno);*/

    //Funciona
/*    @Modifying
    @Query(value = "UPDATE alumno A SET A.nombre = ?1, A.apellido = ?2, A.edad = ?3, A.dni = ?4 WHERE A.id_alumno = ?5", nativeQuery = true)
    int actualizarAlumnoPorID(
            String nombre,
            String apellido,
            int edad,
            String dni,
            int idAlumno);*/

    @Query(value = "SELECT actualizarAlumnoPorID(?1,?2,?3,?4,?5)", nativeQuery = true )
    int actualizarAlumnoPorID(
            String nombre,
            String apellido,
            int edad,
            String dni,
            int idAlumno);

    @Procedure(name = "eliminarAlumno")
    void eliminarAlumnoPorID(int idAlumno);
}
