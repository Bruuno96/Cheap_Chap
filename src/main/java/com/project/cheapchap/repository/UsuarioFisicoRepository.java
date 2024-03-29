package com.project.cheapchap.repository;


import java.util.Optional;

import com.project.cheapchap.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.cheapchap.model.UsuarioFisico;

@Repository
public interface UsuarioFisicoRepository extends JpaRepository<UsuarioFisico, Long>{

	@Transactional(readOnly=true)
	@Query("Select u from UsuarioFisico u where u.email = ?1")
	Optional<Usuario> findByEmail(String email);
	
	// Validacao
	@Transactional(readOnly=true)
	@Query("Select u from UsuarioFisico u where u.cpf = ?1")
	Optional<UsuarioFisico> findByCpf(String cpf);

	@Transactional(readOnly=true)
	@Query("Select u from Usuario u where u.telefone = ?1")
	Optional<UsuarioFisico> findByTelefone(String telefone);
	


}
