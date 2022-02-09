package com.project.cheapchap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cheapchap.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

}
