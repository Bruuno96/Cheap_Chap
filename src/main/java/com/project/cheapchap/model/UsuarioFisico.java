package com.project.cheapchap.model;

import java.time.LocalDate;
import java.util.Calendar;
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
	
	@NotBlank(message = "Campo necessário")
	@Column(name="ds_genero")
	private String genero;
	
	@JsonFormat(pattern="dd/MM/yyyy")
    @DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "dt_nascimento")
    private LocalDate dataNascimento;

	@OneToMany(mappedBy = "usuarioFisico")
	private List<Transacao> transacoes;
	
	@OneToMany(mappedBy = "usuarioFisico")
	private List<Reserva> reservas;
	
	public UsuarioFisico() {
	}
}



