package br.com.banco.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.banco.entity.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{
	
	List<Transferencia> findByTipo(String tipo);
	List<Transferencia> findByTipoAndContaId(String tipo, Long contaId);
	List<Transferencia> findByTipoAndNomeOperador(String tipo, String nomeOperador);
	
	@Query("select a from Transferencia a where a.dateTransf <= :dateTransf and a.tipo= :tipo")
	List<Transferencia> findByDateTransfAndTipo(@Param("dateTransf") Date dateTransf, String tipo);
	
}
