package com.project.cheapchap.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.cheapchap.model.UsuarioFisico;

@Repository
public interface UsuarioFisicoRepository extends JpaRepository<UsuarioFisico, Long>{

	Optional<UsuarioFisico> findByEmail(String email);
	
	// Validacao
	@Transactional(readOnly=true)
	@Query("Select u from UsuarioFisico u where u.cpf = ?1")
	Optional<UsuarioFisico> findByCpf(String cpf);
	
	@Transactional(readOnly=true)
	@Query("Select u.telefone from Usuario u where u.telefone = ?1")
	String findByTelefone(String telefone);
	
	@Transactional(readOnly=true)
	@Query("Select u.rg from Usuario u where u.rg = ?1")
	String findByRg(String rg);

}
