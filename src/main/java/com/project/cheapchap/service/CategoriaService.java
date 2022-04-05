//package com.project.cheapchap.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.cheapchap.controller.api.exception.ObjectNotFoundException;
//import com.project.cheapchap.model.Categoria;
//import com.project.cheapchap.repository.CategoriaRepository;
//
//@Service
//public class CategoriaService {
//
//	@Autowired
//	private CategoriaRepository categoriaRepository;
//
//
//	public Categoria create(Categoria categoria) {
//		categoria.setCategoria(categoria.getCategoria());
//		return categoriaRepository.save(categoria);
//	}
//
//	public List<Categoria> findAll(){
//		return categoriaRepository.findAll();
//	}
//
//	public Categoria findById(Long id) {
//		return categoriaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Evento não encontrado"));
//
//	}
//
//	public Categoria findByName(String categoria){
//		return categoriaRepository.findByName(categoria);
//	}
//}
