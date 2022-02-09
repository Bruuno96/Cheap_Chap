package com.project.cheapchap.service;

import java.util.Optional;

import com.project.cheapchap.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.cheapchap.controller.api.exception.ObjectNotFoundException;
import com.project.cheapchap.repository.UsuarioRepository;

@Service
public class AuthenticationService implements UserDetailsService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> cliente = repository.findByEmail(username);
		if(cliente.isEmpty()) throw new ObjectNotFoundException("Bad Credentials");
		return cliente.get();
	}

	@Bean
	public static PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
