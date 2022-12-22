package br.com.banco.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "transferencia")
public class Transferencia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(name = "data_transferencia")
	@Temporal(TemporalType.DATE)
	public Date dateTransf;
	
	public Double valor;
	public String tipo;
	
	@Column(name = "nome_operador_transacao")
	public String nomeOperador;
	
	@Column(name = "conta_id")
	public Long contaId;
	
}
