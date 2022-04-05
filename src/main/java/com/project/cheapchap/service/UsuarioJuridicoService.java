package com.project.cheapchap.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import com.project.cheapchap.model.*;
import com.project.cheapchap.model.Endereco;
import com.project.cheapchap.repository.RoleRepository;
import com.project.cheapchap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.cheapchap.controller.api.exception.ObjectNotFoundException;
import com.project.cheapchap.repository.UsuarioJuridicoRepository;

@Service
public class UsuarioJuridicoService {

	@Autowired
	public UsuarioJuridicoRepository usuarioJuridicorepository;

	@Autowired
	public UsuarioRepository usuarioRepository;

	@Autowired
	RoleRepository roleRepository;

	public UsuarioJuridico create(UsuarioJuridico u) {
		
		try {
			Carteira c = new Carteira(null,0.00);
			u.setCarteira(c);
			String password = u.getPassword();
			u.setPassword(new BCryptPasswordEncoder().encode(password));
			Role business = roleRepository.findByName("ROLE_BUSINESS");
			u.addRole(business);
			System.out.println(u.getRoles().isEmpty());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarioJuridicorepository.save(u);
	}
	
	public List<UsuarioJuridico> findAll(){
		return usuarioJuridicorepository.findAll();
	}
	
	public UsuarioJuridico findById(Long id) {
		return usuarioJuridicorepository.findById(id).orElseThrow(() -> 
							new ObjectNotFoundException("Objeto nao encontrado:"+id+" Tipo: "+UsuarioJuridico.class.getName()));
	}
	
	public void deleteById(Long id) {
		UsuarioJuridico u  =  usuarioJuridicorepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No object with this ID"));
		usuarioJuridicorepository.delete(Objects.requireNonNull(u));
	}
	
	public UsuarioJuridico updateUser(@Valid UsuarioFisico u, Long id,Endereco e) {
		UsuarioJuridico user = usuarioJuridicorepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No object with this ID"));
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
		
		return usuarioJuridicorepository.save(user);
		
	}


    public  Optional<UsuarioJuridico> findByEmail(String email){
		return usuarioJuridicorepository.findByEmail(email);
	}

	public Optional<UsuarioJuridico> findByCnpj(String cnpj) {
		return usuarioJuridicorepository.findByCnpj(cnpj);
	}

	public Optional<UsuarioJuridico> findByTelefone(String telefone) {
		return usuarioJuridicorepository.findByTelefone(telefone);
	}

}
