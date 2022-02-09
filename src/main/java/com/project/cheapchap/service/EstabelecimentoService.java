package com.project.cheapchap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.cheapchap.model.Estabelecimento;
import com.project.cheapchap.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	public Estabelecimento create(Estabelecimento e) {
		return estabelecimentoRepository.save(e);
	}
	
	public Estabelecimento findById(Long id ) {
		return estabelecimentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Estabelecimento nao encontrado"));
	}
	
	public List<Estabelecimento> findAll(){
		return estabelecimentoRepository.findAll();
	}
	
	public Estabelecimento update(Estabelecimento e, @PathVariable Long id) {
		Estabelecimento updated = findById(id);
		updated.setNomeFantasia(e.getNomeFantasia());
		updated.setEndereco(e.getEndereco());
		updated.setQuantidadeMesas(e.getQuantidadeMesas());
		updated.setReservas(e.getReservas());
		return estabelecimentoRepository.save(updated);
	}
	
	public void delete(@PathVariable Long id) {
		Estabelecimento e = findById(id);
		estabelecimentoRepository.delete(e);
	}
	
	
}
