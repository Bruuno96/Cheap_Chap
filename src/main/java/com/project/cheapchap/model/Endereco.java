package com.project.cheapchap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name="endereco", sequenceName = "SQ_ENDERECO", allocationSize = 1)
public class Endereco implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Column(name="id_endereco")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "endereco")
	private Long idEndereco;
	
	@NotBlank(message = "Campo obrigatório")
	@Column(name="ds_rua", length = 50, nullable = false)
	private String rua;
	
	@NotBlank(message = "Campo obrigatório")
	@Column(name="nr_numero", length = 20, nullable = false)
	private String numero;
	
	@NotBlank(message = "Campo obrigatório")
	@Column(name="ds_bairro", length = 20, nullable = false)
	private String bairro;
	
	@NotBlank(message = "Campo obrigatório")
	@Column(name="ds_cidade", length = 20, nullable = false)
	private String cidade;
	
	@NotBlank(message = "Campo obrigatório")
	@Column(name="ds_cep", length = 10, nullable = false)
	private String cep;
	
	@NotBlank(message = "Campo obrigatório")
	@Column(name="ds_uf", length = 20, nullable = false)
	private String uf;
	
	@Column(name="ds_complemento", length = 30)
	private String complemento;
	
	@JsonIgnore
	@OneToOne(mappedBy = "endereco")
	private Usuario usuario;

	@JsonIgnore
	@OneToOne(mappedBy = "endereco")
	private Evento evento;	
	
	@JsonIgnore
	@OneToOne(mappedBy = "endereco")
	private Estabelecimento estabelecimento;

	public Endereco(Long idEndereco, String rua, String numero, String bairro, String cidade, String cep, String uf,
			String complemento) {
		this.idEndereco = idEndereco;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.uf = uf;
		this.complemento = complemento;
	}

	public Endereco() {
	}
	
	
	
	
}