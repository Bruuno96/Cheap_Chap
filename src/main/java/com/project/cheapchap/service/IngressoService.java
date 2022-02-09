package com.project.cheapchap.service;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.cheapchap.model.Ingresso;
import com.project.cheapchap.repository.IngressoRepository;

@Service
public class IngressoService {

	private IngressoRepository ingressoRepository;
	
	public Ingresso create(Ingresso ingresso) {
		return ingressoRepository.save(ingresso);
	}
	
	public Ingresso findById(Long id) {
		return ingressoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ingresso nao encontrado"));
	}
	
	public List<Ingresso> findAll(){
		return ingressoRepository.findAll();
	}
	
	public void delete(@PathVariable Long id) {
		Ingresso ingresso = findById(id);
		ingressoRepository.delete(ingresso);
	}
	public Ingresso update(Ingresso ingresso, @PathVariable Long id) {
		Ingresso i = findById(id);
		i.setPreco(ingresso.getPreco());
		i.setQuantidadeEstoque(ingresso.getQuantidadeEstoque());
		i.setTipoIngresso(ingresso.getTipoIngresso());
		return ingressoRepository.save(i);
	}
}
