package cl.usach.mingso.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.usach.mingso.entity.Estudiante;
import cl.usach.mingso.services.IColegioService;
import cl.usach.mingso.services.IColegioServiceImpl;
import cl.usach.mingso.services.IEstudianteServiceImpl;

@Controller
@RequestMapping
public class EstudianteController {
	
	@Autowired
	private IEstudianteServiceImpl servicio;
	
	@Autowired
	private IColegioServiceImpl servicioColegio;

    @GetMapping("/agregar_estudiante")
    public String estudiante(){
        return "agregar_estudiante";
    }

    @PostMapping("/agregar_estudiante")
    public String newEstudiante(@RequestParam("rut") String rut,
                                @RequestParam("nombres") String nombres,
                                @RequestParam("apellidos") String apellidos,
                                @RequestParam("fecha_nacimiento") String fecha_nacimiento,
                                @RequestParam("tipo_colegio") String tipo_colegio,
                                @RequestParam("nombre_colegio") String nombre_colegio,
                                @RequestParam("anio_egreso") String anio_egreso) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localFcNacimiento = LocalDate.parse(fecha_nacimiento, formato);
        LocalDate formatAnioEgreso = LocalDate.parse(anio_egreso, formato);
        System.out.println(rut + "  " + nombres + "  " + apellidos + "  " + fecha_nacimiento + " "
        		+ " " + tipo_colegio + "  " + nombre_colegio + "  " + anio_egreso);
        Integer tipoColegio = servicioColegio.findByTipo(tipo_colegio);
        LocalDate formatAnioIngreso = LocalDate.now();
        Estudiante estudiante = new Estudiante();
        estudiante.setRut(rut);
        estudiante.setNombres(nombres);
        estudiante.setApellidos(apellidos);
        estudiante.setFecha_nacimiento(localFcNacimiento);
        estudiante.setTipo_colegio(tipoColegio);
        estudiante.setNombre_colegio(nombre_colegio);        
        estudiante.setAnio_ingreso(formatAnioIngreso);
        estudiante.setAnio_egreso(formatAnioEgreso);
        servicio.registrarEstudiante(estudiante);
        return "agregar_estudiante";
    }

    @GetMapping("/lista_estudiante")
    public String listar(Model model) {
        List<Estudiante> estudianteEntities = servicio.findAll();
        model.addAttribute("estudiantes", estudianteEntities);
        return "lista_estudiante";
    }
}
