package com.project.cheapchap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.cheapchap.model.Evento;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query("select e from Evento e where e.usuarioJuridico.idUsuario = ?1")
    List<Evento> findByUsuarioJuridicoId(@Param("id") Long id);

}
