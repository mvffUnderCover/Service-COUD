package com.santeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoriqueConsultationDTO {
    private String numeroDossier;
    private LocalDate dateConsultation;
    private String examens;
    private String traitements;
    private int nombreTotalVisites;
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	
	public LocalDate getDateConsultation() {
		return dateConsultation;
	}
	public void setDateConsultation(LocalDate dateConsultation) {
		this.dateConsultation = dateConsultation;
	}
	public String getExamens() {
		return examens;
	}
	public void setExamens(String examens) {
		this.examens = examens;
	}
	public String getTraitements() {
		return traitements;
	}
	public void setTraitements(String traitements) {
		this.traitements = traitements;
	}
	public int getNombreTotalVisites() {
		return nombreTotalVisites;
	}
	public void setNombreTotalVisites(int nombreTotalVisites) {
		this.nombreTotalVisites = nombreTotalVisites;
	}
    
}

