package com.project.cheapchap.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.IndexColumn;

import lombok.Getter;
import lombok.Setter;

@PrimaryKeyJoinColumn(name = "id_empresa")

@Getter
@Setter
@Entity
public class UsuarioJuridico extends Usuario {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Campo deve ser preenchido")
	@Column(name = "nm_fantasia", length = 50)
	private String nomeFantasia;

	@NotBlank(message = "Campo deve ser preenchido")
	@Column(name = "ds_cnpj", length = 14)
	private String cnpj;

	@NotBlank(message = "Campo deve ser preenchido")
	@Column(name = "nm_razao_social", length = 15)
	private String razaoSocial;


	@OneToMany(mappedBy = "usuarioJuridico")
	private List<Transacao> transacoes;
	
    @OneToMany(orphanRemoval = true, mappedBy ="usuarioJuridico", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Estabelecimento> estabelecimentos;
	
    @OneToMany(orphanRemoval = true, mappedBy ="usuarioJuridico", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Evento> eventos;

	public UsuarioJuridico() {

	}
	
	public UsuarioJuridico(Long idUsuario, String nome, String ultimoNome, String username, String password,
			String email, String telefone, byte[] fotoPerfil, Collection<Role> roles, Endereco endereco,
			Carteira carteira, String nomeFantasia, String cnpj, String razaoSocial, List<Transacao> transacoes,
			Set<Estabelecimento> estabelecimentos, Set<Evento> eventos) {
		super(idUsuario, nome, ultimoNome, username, password, email, telefone, fotoPerfil, roles, endereco, carteira);
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.transacoes = transacoes;
		this.estabelecimentos = estabelecimentos;
		this.eventos = eventos;
	}	
}

