package com.project.cheapchap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.cheapchap.model.UsuarioJuridico;

@Repository
public interface UsuarioJuridicoRepository extends JpaRepository<UsuarioJuridico, Long>{

    UsuarioJuridico findByEmail(String email);

    @Query("Select u from UsuarioJuridico u where u.cnpj = ?1")
	Optional<UsuarioJuridico> findByCnpj(String cnpj);
}
