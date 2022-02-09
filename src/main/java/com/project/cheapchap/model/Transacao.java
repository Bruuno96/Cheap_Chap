package com.project.cheapchap.model;


import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "sq_transacao", sequenceName = "SQ_TRANSACAO", allocationSize = 1)
public class Transacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_transacao")
	@Column(name = "id_transacao")
	private Long id;

	@Column(name = "dt_movimentacao", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataMovimentacao;

	@Column(name = "vl_transacao", nullable = false)
	private double valorTransacao;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private UsuarioFisico usuarioFisico;

	@ManyToOne
	@JoinColumn(name = "id_empresa", nullable = false)
	private UsuarioJuridico usuarioJuridico;

}