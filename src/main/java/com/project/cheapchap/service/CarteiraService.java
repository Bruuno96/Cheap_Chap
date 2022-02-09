package com.project.cheapchap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cheapchap.model.Carteira;
import com.project.cheapchap.repository.CarteiraRepository;

@Service
public class CarteiraService {

	@Autowired
	private CarteiraRepository carteiraRepository;

	
	public Carteira create(Carteira c) {
		c.setSaldo(0);
		return carteiraRepository.save(c);
	}
}
