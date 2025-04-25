package com.santeservice.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.santeservice.dto.DossierMedicalDTO;
import com.santeservice.model.DossierMedical;

@Component
public class MapToEntityToMap {
	
	public DossierMedicalDTO toDto(DossierMedical entity) {
        DossierMedicalDTO dto = new DossierMedicalDTO();
        dto.setNumeroDossier(entity.getNumeroDossier());
        dto.setIdSecretaire(entity.getIdSecretaire());
        dto.setAntecedent(entity.getAntecedent());
        dto.setGroupeSanguin(entity.getGroupeSanguin());
        dto.setVaccination(entity.getVaccination());
        return dto;
    }

}
