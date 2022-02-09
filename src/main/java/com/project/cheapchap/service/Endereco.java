package com.project.cheapchap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.project.cheapchap.model.Usuario;
import com.project.cheapchap.repository.EnderecoRepository;
import com.project.cheapchap.repository.UsuarioRepository;

@Service
public class Endereco {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
}
