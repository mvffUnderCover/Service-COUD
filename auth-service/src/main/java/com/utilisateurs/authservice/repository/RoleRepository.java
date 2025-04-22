package com.utilisateurs.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utilisateurs.authservice.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
