package com.utilisateurs.authservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.utilisateurs.authservice.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
	
}
