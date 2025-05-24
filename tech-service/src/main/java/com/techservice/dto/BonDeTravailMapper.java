package com.techservice.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.techservice.model.BonDeTravail;

@Component
public class BonDeTravailMapper {

    public BonDeTravailResponseDTO mapToDto(BonDeTravail bon) {
        BonDeTravailResponseDTO dto = new BonDeTravailResponseDTO();
        dto.setIdBonDeTravail(bon.getIdBonDeTravail());
        dto.setIdDemande(bon.getDemande().getIdDemande());
        dto.setEtat(bon.getEtat());
        dto.setNomSection(bon.getSection() != null ? bon.getSection().getNomSection() : null);
        dto.setDescriptionTravail(bon.getDescriptionTravail());
        dto.setLieuIntervention(bon.getLieuIntervention());
        dto.setCreePar(bon.getCreePar());
        return dto;
    }
    
    public BonDeTravailResponseDTO mapToResponseDTO(BonDeTravail bon) {
        BonDeTravailResponseDTO dto = new BonDeTravailResponseDTO();
        dto.setIdBonDeTravail(bon.getIdBonDeTravail());
        dto.setIdDemande(bon.getDemande().getIdDemande());
        dto.setEtat(bon.getEtat());
        dto.setDescriptionTravail(bon.getDescriptionTravail());
        dto.setLieuIntervention(bon.getLieuIntervention());
        dto.setCreePar(bon.getCreePar());
        dto.setNomSection(bon.getSection().getNomSection());
        dto.setIdOuvrier(bon.getIdOuvrier());
        dto.setMaterielConsomme(bon.getMaterielConsomme());
        return dto;
    }
    public BonDeTravailResponseDTO mapToResponseClotureDTO(BonDeTravail bon) {
        BonDeTravailResponseDTO dto = new BonDeTravailResponseDTO();
        dto.setIdBonDeTravail(bon.getIdBonDeTravail());
        dto.setIdDemande(bon.getDemande().getIdDemande());
        dto.setEtat(bon.getEtat());
        dto.setDescriptionTravail(bon.getDescriptionTravail());
        dto.setLieuIntervention(bon.getLieuIntervention());
        dto.setCreePar(bon.getCreePar());
        dto.setNomSection(bon.getSection().getNomSection());
        dto.setIdOuvrier(bon.getIdOuvrier());
        dto.setMaterielConsomme(bon.getMaterielConsomme());
        dto.setDateCloture(bon.getDateCloture());
        return dto;
    }

}

