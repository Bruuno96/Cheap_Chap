package com.project.cheapchap.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@SequenceGenerator(allocationSize = 1, name = "sq_categoria", sequenceName = "SQ_CATEGORIA")
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cd_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_categoria")
	private Long idCategoria;
	
	@Column(name = "nm_categoria")
	private String categoria;
	
	@JsonIgnore
    @OneToMany(mappedBy ="categoria")
	private List<Estabelecimento> estabelecimentos;
    
	@JsonIgnore
    @OneToMany(mappedBy ="categoria")
	private List<Evento> eventos;

	public Categoria(Long idCategoria, String categoria) {
		super();
		this.idCategoria = idCategoria;
		this.categoria = categoria;
	}

	public Categoria() {
	}
    
	
    
}
