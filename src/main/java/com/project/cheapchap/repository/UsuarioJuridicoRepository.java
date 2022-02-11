package com.project.cheapchap.repository;

import java.util.Optional;

import com.project.cheapchap.model.UsuarioFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.cheapchap.model.UsuarioJuridico;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioJuridicoRepository extends JpaRepository<UsuarioJuridico, Long>{

    Optional<UsuarioJuridico> findByEmail(String email);

    @Query("Select u from UsuarioJuridico u where u.cnpj = ?1")
	Optional<UsuarioJuridico> findByCnpj(String cnpj);

    @Transactional(readOnly=true)
    @Query("Select u from Usuario u where u.telefone = ?1")
    Optional<UsuarioJuridico> findByTelefone(String telefone);
}
