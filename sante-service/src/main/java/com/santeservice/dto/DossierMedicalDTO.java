package com.santeservice.dto;

import java.util.ArrayList;
import java.util.List;

public class DossierMedicalDTO {

	private String numeroDossier;
    private String idSecretaire;
    private String nom;
    private String prenom;
    private String niveauEtude;
    private String dateLieuNaissance;
    private String situationFamiliale;
    private Integer nombreEnfants;
    private String antecedent;
    private String groupeSanguin;
    private String vaccination;
    

    public List<ConsultationDTO> getConsultations() {
		return consultations;
	}
	public void setConsultations(List<ConsultationDTO> consultations) {
		this.consultations = consultations;
	}
	public List<MesureDTO> getMesures() {
		return mesures;
	}
	public void setMesures(List<MesureDTO> mesures) {
		this.mesures = mesures;
	}
	private List<ConsultationDTO> consultations = new ArrayList<>();
    private List<MesureDTO> mesures = new ArrayList<>();;
   
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNiveauEtude() {
		return niveauEtude;
	}
	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	public String getDateLieuNaissance() {
		return dateLieuNaissance;
	}
	public void setDateLieuNaissance(String dateLieuNaissance) {
		this.dateLieuNaissance = dateLieuNaissance;
	}
	public String getSituationFamiliale() {
		return situationFamiliale;
	}
	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}
	public Integer getNombreEnfants() {
		return nombreEnfants;
	}
	public void setNombreEnfants(Integer nombreEnfants) {
		this.nombreEnfants = nombreEnfants;
	}
    
}
