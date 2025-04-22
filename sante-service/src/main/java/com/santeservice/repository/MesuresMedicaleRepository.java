package com.santeservice.repository;


import com.santeservice.model.MesuresMedicale;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface MesuresMedicaleRepository extends JpaRepository<MesuresMedicale, Integer> {

	List<MesuresMedicale> findByDossierMedical_NumeroDossier(String numeroDossier);

}
