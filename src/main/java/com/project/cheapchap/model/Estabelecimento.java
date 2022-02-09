package com.project.cheapchap.model;

import java.io.Serializable;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@SequenceGenerator(allocationSize = 1, name = "sq_estabelecimento", sequenceName = "SQ_ESTABELECIMENTO")
public class Estabelecimento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cd_estabelecimento")
	@GeneratedValue(generator = "sq_estabelecimento", strategy = GenerationType.IDENTITY)
	private Long idEstabelecimento;
	
	@Column(name="nm_fantasia")
	private String nomeFantasia;
	
	@Column(name="qtd_mesas")
	private int quantidadeMesas;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@JsonIgnore
	@ManyToOne
	private UsuarioJuridico usuarioJuridico;
	
	@OneToMany(mappedBy = "estabelecimento")
	private List<Reserva> reservas;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cd_categoria")
	private Categoria categoria;

	public Estabelecimento(String nomeFantasia, int quantidadeMesas, Endereco endereco, 
			List<Reserva> reservas) {
		super();
		this.nomeFantasia = nomeFantasia;
		this.quantidadeMesas = quantidadeMesas;
		this.endereco = endereco;
		this.reservas = reservas;
	}

	public Estabelecimento() {
		super();
	}

	
	
}