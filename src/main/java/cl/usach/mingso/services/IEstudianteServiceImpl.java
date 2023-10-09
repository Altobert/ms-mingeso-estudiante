package cl.usach.mingso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.mingso.entity.Estudiante;
import cl.usach.mingso.repository.EstudianteRepository;

@Service
public class IEstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private EstudianteRepository estudianteRepository;
	@Override
	public List<Estudiante> findAll() {
		// TODO Auto-generated method stub
		List<Estudiante> listEstudiantes = estudianteRepository.findAll();
		return listEstudiantes;
	}

}
