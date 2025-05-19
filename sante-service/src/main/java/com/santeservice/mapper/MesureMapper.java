package com.santeservice.mapper;

import java.time.LocalDate;

import com.santeservice.dto.MesureDTO;
import com.santeservice.model.DossierMedical;
import com.santeservice.model.MesuresMedicale;

public class MesureMapper {

    public static MesureDTO toDto(MesuresMedicale entity) {
        if (entity == null) return null;

        MesureDTO dto = new MesureDTO();
        dto.setIdMedecin(entity.getIdMedecin());
        dto.setIdMesure(entity.getIdMesure());
        dto.setDateMesure(entity.getDateMesure());
        dto.setPoids(entity.getPoids());
        dto.setTaille(entity.getTaille());
        dto.setTensionArterielle(entity.getTensionArterielle());
        dto.setPouls(entity.getPouls());

        // Assurez-vous que dossierMedical n'est pas null
        if (entity.getDossierMedical() != null) {
            dto.setNumeroDossier(entity.getDossierMedical().getNumeroDossier());
        }

        return dto;
    }

    public static MesuresMedicale toEntity(MesureDTO dto, DossierMedical dossier) {
        if (dto == null) return null;

        MesuresMedicale entity = new MesuresMedicale();
        entity.setIdMesure(dto.getIdMesure());
        entity.setDateMesure(LocalDate.now());
        entity.setPoids(dto.getPoids());
        entity.setTaille(dto.getTaille());
        entity.setTensionArterielle(dto.getTensionArterielle());
        entity.setPouls(dto.getPouls());
        entity.setDossierMedical(dossier);

        return entity;
    }
}

