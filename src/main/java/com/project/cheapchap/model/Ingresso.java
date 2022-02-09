package com.project.cheapchap.model;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@SequenceGenerator(allocationSize = 1, sequenceName = "SQ_INGRESSO", name = "sq_evento")
public class Ingresso implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cd_ingresso")
	@GeneratedValue(generator = "sq_evento", strategy = GenerationType.IDENTITY)
	private Long idIngresso;
	
	@Column(name="vl_preco")
	private double preco;
	
	@Column(name="qtd_estoque")
	private int quantidadeEstoque;

	@JsonIgnore
	@ManyToOne
	private Evento evento;
	
	@ManyToOne
	private TipoIngresso tipoIngresso;

	public Ingresso(Long idIngresso, double preco, int quantidadeEstoque, Evento evento, TipoIngresso tipoIngresso) {
		super();
		this.idIngresso = idIngresso;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
		this.tipoIngresso = tipoIngresso;
	}

	public Ingresso() {
	}
	
	
	
	
	
	
	
	
}
