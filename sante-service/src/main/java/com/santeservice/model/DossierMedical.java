package com.santeservice.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dossier_medical")
public class DossierMedical {

    @Id
    private String numeroDossier;
    private String idSecretaire;
    private String antecedent;
    private String groupeSanguin;
    private String vaccination;

    @OneToMany(mappedBy = "dossierMedical", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consultation> consultations = new ArrayList<>();

    @OneToMany(mappedBy = "dossierMedical", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MesuresMedicale> mesures = new ArrayList<>();


	public String getNumeroDossier() {
		return numeroDossier;
	}

	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}

	
	public String getIdSecretaire() {
		return idSecretaire;
	}

	public void setIdSecretaire(String idSecretaire) {
		this.idSecretaire = idSecretaire;
	}

	public String getAntecedent() {
		return antecedent;
	}

	public void setAntecedent(String antecedent) {
		this.antecedent = antecedent;
	}

	public String getGroupeSanguin() {
		return groupeSanguin;
	}

	public void setGroupeSanguin(String groupeSanguin) {
		this.groupeSanguin = groupeSanguin;
	}

	public String getVaccination() {
		return vaccination;
	}

	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}

	public List<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public List<MesuresMedicale> getMesures() {
		return mesures;
	}

	public void setMesures(List<MesuresMedicale> mesures) {
		this.mesures = mesures;
	}  
}
