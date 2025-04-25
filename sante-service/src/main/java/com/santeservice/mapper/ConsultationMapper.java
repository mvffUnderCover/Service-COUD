package com.santeservice.mapper;

import com.santeservice.dto.ConsultationDTO;
import com.santeservice.model.Consultation;
import com.santeservice.model.DossierMedical;

public class ConsultationMapper {

    public static ConsultationDTO toDto(Consultation entity) {
        if (entity == null) return null;

        ConsultationDTO dto = new ConsultationDTO();
        dto.setIdConsultation(entity.getIdConsultation());
        dto.setIdMedecin(entity.getIdMedecin());
        dto.setDateConsultation(entity.getDateConsultation());
        dto.setExamens(entity.getExamens());
        dto.setTraitements(entity.getTraitements());

        // Assurez-vous que dossierMedical n'est pas null
        if (entity.getDossierMedical() != null) {
            dto.setNumeroDossier(entity.getDossierMedical().getNumeroDossier());
        }

        return dto;
    }

    public static Consultation toEntity(ConsultationDTO dto, DossierMedical dossier) {
        if (dto == null) return null;

        Consultation entity = new Consultation();
        entity.setIdConsultation(dto.getIdConsultation());
        entity.setIdMedecin(dto.getIdMedecin());
        entity.setDateConsultation(dto.getDateConsultation());
        entity.setExamens(dto.getExamens());
        entity.setTraitements(dto.getTraitements());
        entity.setDossierMedical(dossier);

        return entity;
    }
}

