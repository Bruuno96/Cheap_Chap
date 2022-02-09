package com.project.cheapchap.controller.api;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.cheapchap.model.Endereco;
import com.project.cheapchap.model.UsuarioFisico;
import com.project.cheapchap.model.UsuarioJuridico;
import com.project.cheapchap.service.UsuarioJuridicoService;

@RestController
@RequestMapping(value = "/api")
public class UsuarioJuridicoApi {
	
	@Autowired
	private UsuarioJuridicoService repository;


	@GetMapping("/usuarioJuridico")
	public ResponseEntity<List<UsuarioJuridico>> findAll(){
		List<UsuarioJuridico> u = repository.findAll();
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping("/usuarioJuridico/{id}")
	public ResponseEntity<UsuarioJuridico> findByUserId(@PathVariable Long id){
		UsuarioJuridico u = repository.findById(id); 
		System.out.println(u.getEndereco().getBairro());
		return ResponseEntity.ok().body(u);
	}
	
	@PostMapping("/usuarioJuridico")
	public ResponseEntity<UsuarioJuridico> create(@RequestBody @Valid UsuarioJuridico u, UriComponentsBuilder ucb){
		repository.create(u);
		if(u == null) return ResponseEntity.badRequest().build();
		URI uri = ucb.path("/api/usuarioJuridico/{id}").buildAndExpand(u.getIdUsuario()).toUri();
		return ResponseEntity.created(uri).body(u);
	}
	
	@PutMapping("/usuarioJuridico/{id}")
	public ResponseEntity<UsuarioJuridico> updateUser(@PathVariable Long id, @RequestBody @Valid UsuarioFisico u){
		UsuarioJuridico x = repository.findById(id);
		Endereco e = x.getEndereco();
		UsuarioJuridico updated = repository.updateUser(u,id,e);
		if(updated == null) return ResponseEntity.badRequest().build();
		return ResponseEntity.ok().body(updated);
	}
	
	@DeleteMapping("/usuarioJuridico/{id}")
	public ResponseEntity<UsuarioJuridico> delete(@PathVariable Long id){
		UsuarioJuridico u = repository.findById(id);
		repository.deleteById(id);
		if(u == null) return ResponseEntity.badRequest().build();
		return ResponseEntity.ok().build();
		
	}
	
	
	

	
}
