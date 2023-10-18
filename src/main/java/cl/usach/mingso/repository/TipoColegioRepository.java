package cl.usach.mingso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cl.usach.mingso.entity.TipoColegio;

public interface TipoColegioRepository extends JpaRepository<TipoColegio, Integer>{
	
	@Query("select e from TipoColegio e where e.tipo = :tipo")
	TipoColegio findByTipo(@Param("tipo") String tipo);

}
