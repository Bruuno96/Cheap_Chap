package com.project.cheapchap.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "sq_carteira", sequenceName = "SQ_CARTEIRA", allocationSize = 1)
public class Carteira implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cd_carteira")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sq_carteira")
	private Long idCarteira;
	
	@Column(name="vl_saldo", nullable = false)
	private double saldo;	
}
