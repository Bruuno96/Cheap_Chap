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
import com.project.cheapchap.model.Evento;
import com.project.cheapchap.service.EventoService;

@RestController
@RequestMapping(value = "/api")
public class EventoApi {

	@Autowired
	private EventoService eventoService;
	
		@PostMapping("/evento")
	public ResponseEntity<Evento> register(@RequestBody @Valid Evento evento, UriComponentsBuilder ucb){
		Evento created = eventoService.create(evento);
			if(created == null) return ResponseEntity.badRequest().build();
			URI uri = ucb.path("/api/evento/{id}").buildAndExpand(created).toUri();
		return ResponseEntity.created(uri).body(created);
	}
	
	@PutMapping("/evento/{id}")
	public ResponseEntity<Evento> updateUser(@PathVariable Long id, @RequestBody @Valid Evento u){
		if( u == null) return ResponseEntity.badRequest().build();
		Endereco endereco = eventoService.findById(id).getEndereco();
		Evento x = eventoService.update(u, id,endereco);
		return ResponseEntity.ok().body(x);
	}
	
	@DeleteMapping("/evento/{id}")
	public ResponseEntity<Evento> deleteUser(@PathVariable Long id){
		Evento u = eventoService.findById(id);
		if(u == null) return ResponseEntity.notFound().build();
		eventoService.delete(id);
		return ResponseEntity.ok().build();		
	} 
	
	@GetMapping("/evento/{id}")
	public ResponseEntity<Evento> findByUserId(@PathVariable Long id){
		Evento u = eventoService.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping("/evento")
	public ResponseEntity<List<Evento>> findAll(){
		List<Evento> u = eventoService.findAll();
		return ResponseEntity.ok().body(u);
	}	
}
