package cl.usach.mingso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.mingso.entity.Estudiante;
import cl.usach.mingso.entity.TipoColegio;
import cl.usach.mingso.repository.EstudianteRepository;
import cl.usach.mingso.repository.TipoColegioRepository;

@Service
public class IEstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	private TipoColegioRepository colegioRepository;
	
	@Override
	public List<Estudiante> findAll() {
		// TODO Auto-generated method stub
		List<Estudiante> listEstudiantes = estudianteRepository.findAll();
		return listEstudiantes;
	}
	
	@Override
	public void registrarEstudiante(Estudiante estudiante) {		
		estudianteRepository.save(estudiante);
	}
	
	@Override
	public TipoColegio findIdByTipo(String tipo) {
		TipoColegio tpColegio =  colegioRepository.findByTipo(tipo);
		return tpColegio;
	}
	

}
