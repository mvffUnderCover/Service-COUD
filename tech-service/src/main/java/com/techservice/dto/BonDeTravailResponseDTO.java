package com.techservice.dto;

import java.time.LocalDate;

public class BonDeTravailResponseDTO {
    private Integer idBonDeTravail;
    private String etat;
    private String descriptionTravail;
    private String lieuIntervention;
    private String creePar;
    private String nomSection; // <-- important pour le front
    
    // Vouveaux attributs pour chef de section 
    private String idOuvrier;
    private String materielConsomme;
    
    private LocalDate dateCloture;
    
    // ... autres champs
	public Integer getIdBonDeTravail() {
		return idBonDeTravail;
	}
	public void setIdBonDeTravail(Integer idBonDeTravail) {
		this.idBonDeTravail = idBonDeTravail;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getDescriptionTravail() {
		return descriptionTravail;
	}
	public void setDescriptionTravail(String descriptionTravail) {
		this.descriptionTravail = descriptionTravail;
	}
	public String getLieuIntervention() {
		return lieuIntervention;
	}
	public void setLieuIntervention(String lieuIntervention) {
		this.lieuIntervention = lieuIntervention;
	}
	public String getCreePar() {
		return creePar;
	}
	public void setCreePar(String creePar) {
		this.creePar = creePar;
	}
	public String getNomSection() {
		return nomSection;
	}
	public void setNomSection(String nomSection) {
		this.nomSection = nomSection;
	}
	public String getIdOuvrier() {
		return idOuvrier;
	}
	public void setIdOuvrier(String idOuvrier) {
		this.idOuvrier = idOuvrier;
	}
	public String getMaterielConsomme() {
		return materielConsomme;
	}
	public void setMaterielConsomme(String materielConsomme) {
		this.materielConsomme = materielConsomme;
	}
	public LocalDate getDateCloture() {
		return dateCloture;
	}
	public void setDateCloture(LocalDate dateCloture) {
		this.dateCloture = dateCloture;
	}
	
    
}
