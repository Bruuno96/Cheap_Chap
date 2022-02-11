package com.project.cheapchap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.cheapchap.model.Usuario;
import com.project.cheapchap.model.UsuarioFisico;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByUsername(String username);

	Optional<Usuario> findByEmail(String username);

	@Query("Select u from Usuario u where u.email = ?1")
	Optional<Usuario> findByUserEmail(@Param("email")String email);



}
