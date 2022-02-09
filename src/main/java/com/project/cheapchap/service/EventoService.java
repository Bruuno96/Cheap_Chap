package com.project.cheapchap.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.cheapchap.model.Endereco;
import com.project.cheapchap.model.Evento;
import com.project.cheapchap.repository.EventoRepository;

@Service
public class EventoService {

	
	@Autowired
	private EventoRepository eventoRepository;
	
	public Evento create(Evento evento) {
		return eventoRepository.save(evento);
	}
	
	public Evento findById(Long id) {
		return eventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No event found"));
	}
	
	public List<Evento> findAll(){
		return eventoRepository.findAll();
	}
	
	public void delete(@PathVariable Long id) {
		Evento e = findById(id);
		eventoRepository.delete(Objects.requireNonNull(e));
	}
	
	public Evento update(Evento e ,Long id,Endereco endereco) {
		Evento evento = eventoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No data"));
		evento.setNomeEvento(e.getNomeEvento());
		evento.setDataInicio(e.getDataInicio());
		evento.setDataTermino(e.getDataTermino());
		evento.setDescricao(e.getDescricao());
		evento.setFotoBanner(e.getDescricao());
		evento.setNumeroVagasEstacionamento(e.getNumeroVagasEstacionamento());
		endereco.setRua(e.getEndereco().getRua());
		endereco.setNumero(e.getEndereco().getNumero());
		endereco.setBairro(e.getEndereco().getBairro());
		endereco.setCidade(e.getEndereco().getCidade());
		endereco.setCep(e.getEndereco().getCep());
		endereco.setUf(e.getEndereco().getUf());
		endereco.setComplemento(e.getEndereco().getComplemento());
		return eventoRepository.save(evento);
	}
}
