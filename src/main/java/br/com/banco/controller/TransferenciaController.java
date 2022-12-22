package br.com.banco.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entity.Transferencia;
import br.com.banco.service.TransferenciaService;

@RestController
public class TransferenciaController {
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	// sem filtro, retorna todos os dados de transferência
	@GetMapping("/transferencia") 
	public List<Transferencia> findbyTipo(@RequestParam(defaultValue = "TRANSFERENCIA") String tipo){
		return transferenciaService.findbyTipo(tipo);
	}
	
	// fornece os dados de tansferencias pelo ID da conta bancária
	@GetMapping("/contaid")
	public List<Transferencia> findbyId(@RequestParam(defaultValue = "TRANSFERENCIA") String tipo, @RequestParam Long contaId){
		return transferenciaService.findbyId(tipo, contaId);
	}
	
	// retornar todas as transferências por operador
	@GetMapping("/nomeoperador")
	public List<Transferencia> findbyOperador(@RequestParam(defaultValue = "TRANSFERENCIA") String tipo, @RequestParam String nomeOperador){
		return transferenciaService.findbyOperador(tipo, nomeOperador);
	}
	
	// retorna todas as transferências por data
	@GetMapping("/date")
	public List<Transferencia> findbyDate(
			@RequestParam(defaultValue = "TRANSFERENCIA") String tipo,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTransf) {
		return transferenciaService.findByDate(tipo, dateTransf);
	}
	
}
