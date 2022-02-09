package com.project.cheapchap.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

import lombok.Data;

@Data 
@Entity
@SequenceGenerator(allocationSize = 1, name = "sq_reserva", sequenceName = "SQ_RESERVA")
public class Reserva implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cd_reserva")
	@GeneratedValue(generator = "sq_reserva", strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="dt_reserva")
	private Calendar dataReserva;
	
	@Column(name="qtd_pessoas")
	private int quantidadePessoas;
	
	@Column(name="ds_convidados")
	private String descricaoConvidados;
	
	@ManyToOne
	@JoinColumn(name="cd_estabelecimento")
	private Estabelecimento estabelecimento;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private UsuarioFisico usuarioFisico;
	

	
}