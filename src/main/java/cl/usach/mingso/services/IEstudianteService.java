package cl.usach.mingso.services;

import java.util.List;

import cl.usach.mingso.entity.Estudiante;
import cl.usach.mingso.entity.TipoColegio;

public interface IEstudianteService {
	
	public List<Estudiante> findAll();
	
	public void registrarEstudiante(Estudiante estudiante);
	
	public TipoColegio findIdByTipo(String tipo);

}
