package com.project.cheapchap.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(allocationSize = 1, sequenceName = "SQ_EVENTO", name = "sq_evento")
public class Evento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cd_evento")
	@GeneratedValue(generator = "sq_evento", strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nm_evento")
	private String nomeEvento;
	
	@Column(name="ft_banner")
	private String fotoBanner;
	
	@Column(name="dt_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInicio;
	
	@Column(name="dt_fim")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataTermino;
	
	@Column(name="ds_descricao")
	private String descricao;
	
	@Column(name="nr_vagas_estacionamento")
	private int numeroVagasEstacionamento;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private UsuarioJuridico usuarioJuridico;
	
	@OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Ingresso> ingresso;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Evento(Long id, String nome, String fotoBanner, Calendar dataInicio, Calendar dataTermino, String descricao,
			int numeroVagasEstacionamento, Set<Ingresso> ingresso,Categoria categoria,Endereco e) {
		super();
		this.id = id;
		this.nomeEvento = nome;
		this.fotoBanner = fotoBanner;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.descricao = descricao;
		this.numeroVagasEstacionamento = numeroVagasEstacionamento;
		this.ingresso = ingresso;
		this.categoria = categoria;
		this.endereco = e;
		}

	public Evento() {
	}
	
	
	
	
	

}