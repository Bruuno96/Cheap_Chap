package com.project.cheapchap.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@PrimaryKeyJoinColumn(name = "id_usuario")

@Getter
@Setter
@Entity
public class UsuarioFisico extends Usuario{

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Dcoumento CPF deve ser preenchido")
	@Column(name = "ds_cpf", unique = true)
	private String cpf;
	
	@NotBlank(message = "Dcoumento RG deve ser preenchido")
	@Column(name = "ds_rg", unique = true)
	private String rg;
	
	@NotBlank(message = "Campo necessário")
	@Column(name="ds_genero")
	private String genero;
	
	@NotBlank(message = "Preencha com a data de seu nascimento")
	@JsonFormat(pattern="dd/MM/yyyy")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private String dataNascimento;

	@OneToMany(mappedBy = "usuarioFisico")
	private List<Transacao> transacoes;
	
	@OneToMany(mappedBy = "usuarioFisico")
	private List<Reserva> reservas;
	
	public UsuarioFisico() {
	}

	public UsuarioFisico(Long idUsuario, String nome, String ultimoNome, String username, String password, String email,
			String telefone, byte[] fotoPerfil, Collection<Role> roles, Endereco endereco, Carteira carteira,
			String cpf, String dataNascimento, List<Transacao> transacoes, List<Reserva> reservas) {
		super(idUsuario, nome, ultimoNome, username, password, email, telefone, fotoPerfil, roles, endereco, carteira);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.transacoes = transacoes;
		this.reservas = reservas;
	}
}



