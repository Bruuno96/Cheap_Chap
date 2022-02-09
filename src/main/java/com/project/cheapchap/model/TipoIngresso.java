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

@Getter
@Setter
@Entity
@SequenceGenerator(name = "sq_tipo_ingresso", sequenceName = "SQ_INGRESSO", allocationSize = 1)
public class TipoIngresso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cd_tipo_ingresso")
	@GeneratedValue(generator = "sq_tipo_ingresso", strategy = GenerationType.IDENTITY)
	private Long idTipoIngresso;
	
	@Column(name="nm_ingresso")
	private String tipo;
	
	@JsonIgnore
	@OneToMany(mappedBy ="tipoIngresso")
	private List<Ingresso> ingresso;

	public TipoIngresso(Long idTipoIngresso, String tipo) {
		this.idTipoIngresso = idTipoIngresso;
		this.tipo = tipo;
	}

	public TipoIngresso() {
	}
	
	
	
	
}
