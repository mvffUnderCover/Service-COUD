package com.utilisateurs.authservice.repository;

import com.utilisateurs.authservice.model.Authentification;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthentificationRepository extends JpaRepository<Authentification, Integer> {
	Optional<Authentification> findByUtilisateurImmatricul(String immatricul);
	boolean existsByUtilisateurImmatricul(String immatricul);

}
