package cl.usach.mingso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.usach.mingso.entity.Estudiante;
import cl.usach.mingso.services.IEstudianteServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	private IEstudianteServiceImpl servicio;

	 @GetMapping("/")
	 public String mostrarEstudiantes(Model model) {
        List<Estudiante> listEstudiantes = servicio.findAll();
        model.addAttribute("estudiantes", listEstudiantes);
        return "estudiantes";
	 }
}
