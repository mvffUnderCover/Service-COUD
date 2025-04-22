package com.techservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techservice.model.BonDeTravail;

@Repository
public interface BonDeTravailRepository extends JpaRepository<BonDeTravail, Integer> {

	    List<BonDeTravail> findByEtat(String etat);

	    List<BonDeTravail> findByIdOuvrier(String idOuvrier);

	    List<BonDeTravail> findBySection_IdSection(Integer idSection); 

	
	
}
