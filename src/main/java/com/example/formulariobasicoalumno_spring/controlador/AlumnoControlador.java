package com.example.formulariobasicoalumno_spring.controlador;

import com.example.formulariobasicoalumno_spring.modelo.Alumno;
import com.example.formulariobasicoalumno_spring.servicio.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/alumnos")
public class AlumnoControlador {

    @Autowired
    private AlumnoServicio alumnoServicio;

    /**
     * Metodo que muestra la pagina principal
     * y el listado de alumnos
     * @return
     */
    @GetMapping("/")
    public String mostrarAlumnos(Model model){
        //alamcenar lista de alumnos
        List<Alumno> alumnos = this.alumnoServicio.mostrarAlumnos();

        //agregar a la vista el listado de alumnos
        model.addAttribute("alumnos", alumnos);
        return "home";
    }

    @GetMapping("/crearAlumno")
    public String formularioAlumno(Model model){
        Alumno nuevoAlumno = new Alumno();
        model.addAttribute("nuevoAlumno", nuevoAlumno);
        return "formularioAlumno";
    }

    @PostMapping("/crearAlumno")
    public String creaAlumno(@ModelAttribute Alumno nuevoAlumno){
        System.out.println(nuevoAlumno);
        this.alumnoServicio.crearAlumno(nuevoAlumno);

        return "redirect:/alumnos/";
    }


}
