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
import com.project.cheapchap.service.UsuarioFisicoService;

@RestController
@RequestMapping(value = "/api")
public class UsuarioFisicoApi {

	@Autowired
	private UsuarioFisicoService usuarioService;
	
	@PostMapping("/usuarioFisico")
	public ResponseEntity<UsuarioFisico> register(@RequestBody @Valid UsuarioFisico u, UriComponentsBuilder ucb){
		UsuarioFisico created = usuarioService.create(u);
			if(created == null) return ResponseEntity.badRequest().build();
			URI uri = ucb.path("/api/usuarioFisico/{id}").buildAndExpand(created.getIdUsuario()).toUri();
		return ResponseEntity.created(uri).body(created);
	}
	
	@PutMapping("/usuarioFisico/{id}")
	public ResponseEntity<UsuarioFisico> updateUser(@PathVariable Long id, @RequestBody @Valid UsuarioFisico u){
		UsuarioFisico x = usuarioService.findById(id);
		Endereco e = x.getEndereco();
		UsuarioFisico updated = usuarioService.updateUser(u, id,e);
		if(updated == null) return ResponseEntity.badRequest().build();
		return ResponseEntity.ok().body(updated);
	}
	
	@DeleteMapping("/usuarioFisico/{id}")
	public ResponseEntity<UsuarioFisico> deleteUser(@PathVariable Long id){
		UsuarioFisico u = usuarioService.findById(id);
		if(u == null) return ResponseEntity.notFound().build();
		usuarioService.delete(id);
		return ResponseEntity.ok().build();		
	} 
	
	@GetMapping("/usuarioFisico/{id}")
	public ResponseEntity<UsuarioFisico> findByUserId(@PathVariable Long id){
		UsuarioFisico u = usuarioService.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping("/usuarioFisico")
	public ResponseEntity<List<UsuarioFisico>> findAllUsers(){
		List<UsuarioFisico> u = usuarioService.findAll();
		return ResponseEntity.ok().body(u);
	}	
}
