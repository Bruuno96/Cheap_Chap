package com.project.cheapchap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cheapchap.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
