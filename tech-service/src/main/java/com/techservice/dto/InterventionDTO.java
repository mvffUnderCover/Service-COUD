package com.techservice.dto;

import java.time.LocalDate;

public class InterventionDTO {

    private Integer idBon;
    private String statutDemande;
    private String idEtudiant;
    private String pavillon;
    private Integer numChambre;
    private LocalDate dateSoumission;

    private String section;
    private String idOuvrier;
    private String lieuIntervention;
    private String descriptionTravail;
    private String materielConsomme;

    private LocalDate dateCreation;
    private LocalDate dateIntervention;
    private LocalDate dateCloture;
    
    
	public Integer getIdBon() {
		return idBon;
	}
	public void setIdBon(Integer idBon) {
		this.idBon = idBon;
	}
	public String getStatutDemande() {
		return statutDemande;
	}
	public void setStatutDemande(String statutDemande) {
		this.statutDemande = statutDemande;
	}
	public String getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(String idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getPavillon() {
		return pavillon;
	}
	public void setPavillon(String pavillon) {
		this.pavillon = pavillon;
	}
	public Integer getNumChambre() {
		return numChambre;
	}
	public void setNumChambre(Integer numChambre) {
		this.numChambre = numChambre;
	}
	public LocalDate getDateSoumission() {
		return dateSoumission;
	}
	public void setDateSoumission(LocalDate dateSoumission) {
		this.dateSoumission = dateSoumission;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getIdOuvrier() {
		return idOuvrier;
	}
	public void setIdOuvrier(String idOuvrier) {
		this.idOuvrier = idOuvrier;
	}
	public String getLieuIntervention() {
		return lieuIntervention;
	}
	public void setLieuIntervention(String lieuIntervention) {
		this.lieuIntervention = lieuIntervention;
	}
	public String getDescriptionTravail() {
		return descriptionTravail;
	}
	public void setDescriptionTravail(String descriptionTravail) {
		this.descriptionTravail = descriptionTravail;
	}
	public String getMaterielConsomme() {
		return materielConsomme;
	}
	public void setMaterielConsomme(String materielConsomme) {
		this.materielConsomme = materielConsomme;
	}
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	public LocalDate getDateIntervention() {
		return dateIntervention;
	}
	public void setDateIntervention(LocalDate dateIntervention) {
		this.dateIntervention = dateIntervention;
	}
	public LocalDate getDateCloture() {
		return dateCloture;
	}
	public void setDateCloture(LocalDate dateCloture) {
		this.dateCloture = dateCloture;
	}
        
}
