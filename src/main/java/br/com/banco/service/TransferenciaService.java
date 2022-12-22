package br.com.banco.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entity.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	public List<Transferencia> findbyTipo(String tipo) {
		return transferenciaRepository.findByTipo(tipo);
	}
	
	public List<Transferencia> findbyId(String tipo, Long contaId) {
		return transferenciaRepository.findByTipoAndContaId(tipo, contaId);
	}
	
	public List<Transferencia> findbyOperador(String tipo, String nomeOperador) {
		return transferenciaRepository.findByTipoAndNomeOperador(tipo, nomeOperador);
	}
	
	public List<Transferencia> findByDate(String tipo, Date dateTransf){
		return transferenciaRepository.findByDateTransfAndTipo(dateTransf, tipo);
	}

}
