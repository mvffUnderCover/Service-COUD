package com.etudiants.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etudiants.model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, String> {

	Optional<Etudiant> findByEmailAndNumcarte(String email, String numcarte);
	Optional<Etudiant> findByEmail(String email);
}
