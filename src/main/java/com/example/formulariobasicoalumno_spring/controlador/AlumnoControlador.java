package com.example.formulariobasicoalumno_spring.controlador;

import com.example.formulariobasicoalumno_spring.modelo.Alumno;
import com.example.formulariobasicoalumno_spring.servicio.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/alumnos")
public class AlumnoControlador {

    @Autowired
    private AlumnoServicio alumnoServicio;

    /**
     * Metodo que muestra la pagina principal
     * con el listado de alumnos
     * @return index.html
     */
    @GetMapping("/")
    public String mostrarListadoAlumnos(Model model){
        //alamcenar lista de alumnos
        List<Alumno> alumnos = this.alumnoServicio.mostrarAlumnos();
        //agregar a la vista el listado de alumnos
        model.addAttribute("alumnos", alumnos);

        return "index";
    }

    @GetMapping("/crearAlumno")
    public String formularioAlumno(Model model){
        Alumno nuevoAlumno = new Alumno();
        model.addAttribute("nuevoAlumno", nuevoAlumno);
        return "crear-alumno";
    }


    @PostMapping("/crearAlumno")
    public String creaAlumno(@ModelAttribute Alumno nuevoAlumno,
                             RedirectAttributes attributes){
        //registrar alumno en la BBDD
        this.alumnoServicio.crearAlumno(nuevoAlumno);
        //mostrar que el alumno ha sido creado
        attributes.addFlashAttribute(
                "creado",
                " ¡alumno " + nuevoAlumno.getNombre() + " creado con exito!");
        return "redirect:/alumnos/";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable("id") int idAlumno){
        //eliminar alumno
        this.alumnoServicio.eliminarAlumnoPorID(idAlumno);

        return "redirect:/alumnos/";
    }

    @GetMapping("/editar/{id}")
    public String editarAlumno(@PathVariable("id") int idAlumno,
                                Model model){
        //buscar el alumno a actualizar
        Alumno alumnoEncontrado = this.alumnoServicio.buscarAlumnoPorID(idAlumno);
        //añadir el alumno encontrado a la vista
        model.addAttribute("alumnoEncontrado", alumnoEncontrado);

        return "actualizar-alumno";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarAlumno(@PathVariable("id") int idAlumno,
                                    @ModelAttribute Alumno alumnoActualizado,
                                   RedirectAttributes redirectAttributes){
        //actualizar alumno
        this.alumnoServicio.actualizarAlumnoPorID(idAlumno, alumnoActualizado);
        //mostrar que el alumno ha sido actualizado
        redirectAttributes.addFlashAttribute(
                "actualizado",
                " ¡alumno " + alumnoActualizado.getNombre() + " actualizado con exito!");

        return "redirect:/alumnos/";
    }


}
