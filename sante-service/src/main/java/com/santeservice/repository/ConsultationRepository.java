package com.santeservice.repository;

import com.santeservice.model.Consultation;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

	List<Consultation> findByDossierMedical_NumeroDossier(String numeroDossier);

}
