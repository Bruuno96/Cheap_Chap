//package com.project.cheapchap.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.project.cheapchap.model.Categoria;
//
//@Repository
//public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
//
//    @Query("select c from Categoria c where c.categoria = ?1")
//    Categoria findByName(@Param("categoria") String categoria);
//}
