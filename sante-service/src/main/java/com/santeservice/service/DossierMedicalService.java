package com.santeservice.service;

import com.santeservice.dto.ConsultationDTO;
import com.santeservice.dto.DossierMedicalDTO;
import com.santeservice.dto.HistoriqueConsultationDTO;
import com.santeservice.dto.MesureDTO;

import java.util.List;

public interface DossierMedicalService {
    DossierMedicalDTO create(DossierMedicalDTO dto);
    DossierMedicalDTO update(String numeroDossier, DossierMedicalDTO dto);
    DossierMedicalDTO getByNumero(String numeroDossier);
    List<DossierMedicalDTO> getAll();
    void delete(String numeroDossier);
    
 // Gestion des consultations
    ConsultationDTO addConsultation(String numeroDossier, ConsultationDTO consultationDTO);
    List<ConsultationDTO> getConsultationsByDossier(String numeroDossier);
    ConsultationDTO updateConsultation(String numeroDossier, Integer id, ConsultationDTO dto);

    // Gestion des mesures médicales
    MesureDTO addMesure(String numeroDossier, MesureDTO mesureDTO);
    List<MesureDTO> getMesuresByDossier(String numeroDossier);
    MesureDTO updateMesure(String numeroDossier, Integer id, MesureDTO dto);
    
    //Historique des consultation
    List<HistoriqueConsultationDTO> getHistoriqueConsultations();

}
