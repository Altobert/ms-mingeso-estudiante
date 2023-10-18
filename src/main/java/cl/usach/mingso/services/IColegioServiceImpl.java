package cl.usach.mingso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.mingso.entity.TipoColegio;
import cl.usach.mingso.repository.TipoColegioRepository;

@Service
public class IColegioServiceImpl implements IColegioService{
	
	@Autowired
	TipoColegioRepository colegioRepository;

	@Override
	public Integer findByTipo(String tipo) {
		// TODO Auto-generated method stub
		TipoColegio tpColegio =  colegioRepository.findByTipo(tipo);
		return tpColegio.getId();
	}

}
