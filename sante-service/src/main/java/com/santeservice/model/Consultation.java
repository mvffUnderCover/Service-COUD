package com.santeservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsultation;

    private String idMedecin;

   
    private LocalDate dateConsultation;

    private String examens;
    private String traitements;

    @ManyToOne
    @JoinColumn(name = "numero_dossier")
    private DossierMedical dossierMedical;

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

	

	public String getTraitements() {
		return traitements;
	}

	public void setTraitements(String traitements) {
		this.traitements = traitements;
	}

	public DossierMedical getDossierMedical() {
		return dossierMedical;
	}

	public void setDossierMedical(DossierMedical dossierMedical) {
		this.dossierMedical = dossierMedical;
	}

	public String getExamens() {
		return examens;
	}

	public void setExamens(String examens) {
		this.examens = examens;
	}

	public LocalDate getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(LocalDate dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

    // Getters & Setters
    
}
