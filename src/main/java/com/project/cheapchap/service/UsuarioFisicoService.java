package com.project.cheapchap.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.project.cheapchap.model.*;
import com.project.cheapchap.model.Endereco;
import com.project.cheapchap.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.cheapchap.controller.api.exception.ObjectNotFoundException;
import com.project.cheapchap.repository.UsuarioFisicoRepository;

@Service
public class UsuarioFisicoService {

	@Autowired
	public UsuarioFisicoRepository usuarioFisicoRepository;

	@Autowired
	private 	RoleRepository roleRepository;
	
	public UsuarioFisico create (UsuarioFisico u) {
			Carteira c = new Carteira(null,0.00);
			u.setCarteira(c);
			String password = u.getPassword();
			u.setPassword(new BCryptPasswordEncoder().encode(password));
			Role roleUser = roleRepository.findByName("ROLE_USER");
			u.addRole(roleUser);
			return usuarioFisicoRepository.save(u);
	}
	
	public UsuarioFisico findById(Long id) {
		return usuarioFisicoRepository.findById(id).orElseThrow(() -> 
							new ObjectNotFoundException("Objeto nao encontrado:"+id+" Tipo: "+UsuarioFisico.class.getName()));
	}
	
	public List<UsuarioFisico> findAll(){
		return usuarioFisicoRepository.findAll();
	}
	
	public void delete(Long id) {
		UsuarioFisico userFound = usuarioFisicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No object with this ID"));
		usuarioFisicoRepository.delete(userFound);
	}
	
	// Implementar regras de qual dado pode ou não ser atualizado. 
	public UsuarioFisico updateUser(UsuarioFisico u, Long id,Endereco e) {
		UsuarioFisico user = usuarioFisicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No object with this ID"));
		user.setNome(u.getNome());
		user.setUltimoNome(u.getUltimoNome());
		user.setUsername(u.getUsername());
		user.setPassword(u.getPassword());
		user.setEmail(u.getEmail());
		user.setTelefone(u.getTelefone());
		user.setFotoPerfil(u.getFotoPerfil());
		e.setRua(u.getEndereco().getRua());
		e.setNumero(u.getEndereco().getNumero());
		e.setBairro(u.getEndereco().getBairro());
		e.setCidade(u.getEndereco().getCidade());
		e.setCep(u.getEndereco().getCep());
		e.setUf(u.getEndereco().getUf());
		e.setComplemento(u.getEndereco().getComplemento());
		user.setEndereco(e);
		
		return usuarioFisicoRepository.save(user);
		
	}

	public Optional<Usuario> findByEmail(String email) {
		return usuarioFisicoRepository.findByEmail(email);
	}

	public Optional<UsuarioFisico> findByCpf(String cnpj) {
		return usuarioFisicoRepository.findByCpf(cnpj);
	}

	
	public Optional<UsuarioFisico> findByTelefone(String telefone) {
		return usuarioFisicoRepository.findByTelefone(telefone);
	}
	

}
