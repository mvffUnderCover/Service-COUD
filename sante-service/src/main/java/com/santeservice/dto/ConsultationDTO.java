package com.santeservice.dto;

import java.util.Date;

public class ConsultationDTO {

    private Integer idConsultation;
    private String idMedecin;
    private Date dateConsultation;
    private String examens;
    private String traitements;
    private String numeroDossier;
	public Integer getIdConsultation() {
		return idConsultation;
	}
	public void setIdConsultation(Integer idConsultation) {
		this.idConsultation = idConsultation;
	}
	public String getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(String idMedecin) {
		this.idMedecin = idMedecin;
	}
	public Date getDateConsultation() {
		return dateConsultation;
	}
	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}
	
	public String getTraitements() {
		return traitements;
	}
	public void setTraitements(String traitements) {
		this.traitements = traitements;
	}
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	public String getExamens() {
		return examens;
	}
	public void setExamens(String examens) {
		this.examens = examens;
	}

    // Getters & Setters
    
}
