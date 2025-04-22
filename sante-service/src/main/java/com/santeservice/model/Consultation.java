package com.santeservice.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsultation;

    private String idMedecin;

    @Temporal(TemporalType.DATE)
    private Date dateConsultation;

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

    // Getters & Setters
    
}
