package com.techservice.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.techservice.model.AvisEtudiant;
import com.techservice.model.BonDeTravail;


public interface AvisEtudiantRepository extends JpaRepository<AvisEtudiant, Integer> {
	Optional<AvisEtudiant> findByBonDeTravail(BonDeTravail bon);
	List<AvisEtudiant> findAllByBonDeTravail(BonDeTravail bon);

}
