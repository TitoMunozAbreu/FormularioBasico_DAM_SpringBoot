package com.example.formulariobasicoalumno_spring.controlador;

import com.example.formulariobasicoalumno_spring.modelo.Alumno;
import com.example.formulariobasicoalumno_spring.servicio.AlumnoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String mostrarListadoAlumnos(Model model,
                                        @PageableDefault(size = 5)
                                        Pageable pageable){
        //Añadir objeto pageable al template
        Page alumnoPage = this.alumnoServicio.mostrarAlumnos(pageable);
        //alamcenar lista de alumnos

        //agregar a la vista el listado de alumnos
        model.addAttribute("alumnos", alumnoPage);

        return "index";
    }

    @GetMapping("/crearAlumno")
    public String formularioAlumno(Model model){
        Alumno nuevoAlumno = new Alumno();
        model.addAttribute("nuevoAlumno", nuevoAlumno);
        return "crear-alumno";
    }


    @PostMapping("/crearAlumno")
    public String creaAlumno(@Valid @ModelAttribute("nuevoAlumno") Alumno nuevoAlumno,
                             BindingResult result,
                             RedirectAttributes attributes){
        //comprobar si existen errores en la validación
        if(result.hasErrors()){
            return "crear-alumno";
        }
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
        System.out.println("alumno seleccionado a eliminar: " + idAlumno);
        this.alumnoServicio.eliminarAlumnoPorID(idAlumno);

        return "redirect:/alumnos/";
    }

    @GetMapping("/editar/{id}")
    public String editarAlumno(@PathVariable("id") int idAlumno,
                                Model model){
        System.out.println("alumno seleccionado a editar: " + idAlumno);

        //buscar el alumno a actualizar
        Alumno alumnoEncontrado = this.alumnoServicio.buscarAlumnoPorID(idAlumno);
        //añadir el alumno encontrado a la vista
        model.addAttribute("alumnoEncontrado", alumnoEncontrado);

        return "actualizar-alumno";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarAlumno(@PathVariable("id") int idAlumno,
                                    @Valid @ModelAttribute("alumnoEncontrado") Alumno alumnoActualizado,
                                   BindingResult result,
                                   RedirectAttributes redirectAttributes){
        //comprobar si existen errores en la validación

        if(result.hasErrors()){
            return "actualizar-alumno";
        }
        //actualizar alumno
        this.alumnoServicio.actualizarAlumnoPorID(idAlumno, alumnoActualizado);
        //mostrar que el alumno ha sido actualizado
        redirectAttributes.addFlashAttribute(
                "actualizado",
                " ¡alumno " + alumnoActualizado.getNombre() + " actualizado con exito!");

        return "redirect:/alumnos/";
    }


}
