package com.project.cheapchap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cheapchap.model.Role;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long>{

    @Query("Select r from Role r where r.name = ?1")
    public Role findByName(String nome);
}
