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
import com.project.cheapchap.model.Estabelecimento;
import com.project.cheapchap.service.EstabelecimentoService;

@RestController
@RequestMapping(value = "/api")
public class EstabelecimentoApi {

	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@PostMapping("/estabelecimento")
	public ResponseEntity<Estabelecimento> register(@RequestBody @Valid Estabelecimento Estabelecimento, UriComponentsBuilder ucb){
		Estabelecimento created = estabelecimentoService.create(Estabelecimento);
			if(created == null) return ResponseEntity.badRequest().build();
			URI uri = ucb.path("/api/Estabelecimento/{id}").buildAndExpand(created).toUri();
		return ResponseEntity.created(uri).body(created);
	}
	
	@PutMapping("/estabelecimento/{id}")
	public ResponseEntity<Estabelecimento> updateUser(Endereco e,@PathVariable Long id, @RequestBody @Valid Estabelecimento u){
		if( u == null) return ResponseEntity.badRequest().build();
		Estabelecimento x = estabelecimentoService.findById(id);
		x.setNomeFantasia(u.getNomeFantasia());
		x.setQuantidadeMesas(u.getQuantidadeMesas());
		e.setRua(u.getEndereco().getRua());
		e.setNumero(u.getEndereco().getNumero());
		e.setBairro(u.getEndereco().getBairro());
		e.setCidade(u.getEndereco().getCidade());
		e.setCep(u.getEndereco().getCep());
		e.setUf(u.getEndereco().getUf());
		e.setComplemento(u.getEndereco().getComplemento());
		return ResponseEntity.ok().body(x);
	}
	
	@DeleteMapping("/estabelecimento/{id}")
	public ResponseEntity<Estabelecimento> deleteUser(@PathVariable Long id){
		Estabelecimento u = estabelecimentoService.findById(id);
		if(u == null) return ResponseEntity.notFound().build();
		estabelecimentoService.delete(id);
		return ResponseEntity.ok().build();		
	} 
	
	@GetMapping("/estabelecimento/{id}")
	public ResponseEntity<Estabelecimento> findByUserId(@PathVariable Long id){
		Estabelecimento u = estabelecimentoService.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping("/estabelecimento")
	public ResponseEntity<List<Estabelecimento>> findAll(){
		List<Estabelecimento> u = estabelecimentoService.findAll();
		return ResponseEntity.ok().body(u);
	}	
}
