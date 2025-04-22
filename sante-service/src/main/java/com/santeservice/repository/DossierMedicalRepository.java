package com.santeservice.repository;

import com.santeservice.model.DossierMedical;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical, String> {

	Optional<DossierMedical> findByNumeroDossier(String numeroDossier);
}
