package com.project.cheapchap.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "role", sequenceName = "SQ_ROLE", allocationSize = 1)
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cd_role")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "role")
	private Long id;
	
	@Column(name="nm_role")
	@NotBlank
	private String name;
	
	@Override
	public String getAuthority() {
		return this.name;
	}
}