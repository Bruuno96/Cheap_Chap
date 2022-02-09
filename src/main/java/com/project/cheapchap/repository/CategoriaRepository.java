package com.project.cheapchap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cheapchap.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{


}
