package com.techservice.dto;

public class BonDeTravailRequest {
    // Étape 1 : Création du bon de travail par le chef de résidence
    private Integer idBon;
	private Integer idDemande;
    private String idChefDeResidence;
    private String descriptionTravail;
    private String lieuIntervention;

    // Étape 2 : Mise à jour par le chef des ateliers
    private String idChefAtelier;
    private String section;     // nom ou libellé de la section
    private Integer idSection;     // identifiant de la section

    // Étape 3 : Mise à jour par le chef de section
    private String idChefSection;
    private String materielConsomme;
    private String idOuvrierAffecte;

    // Étape 4 : Mise à jour par l'ouvrier
    private String idOuvrier;
    private String etatTravail; // "en cours", "exécuté", etc.

    // Étape 5 : Clôture par le chef de résidence
    private String etat; // "cloturé", "rejeté", etc.

    // Getters et Setters

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public String getIdChefDeResidence() {
        return idChefDeResidence;
    }

    public void setIdChefDeResidence(String idChefDeResidence) {
        this.idChefDeResidence = idChefDeResidence;
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

    public String getIdChefAtelier() {
        return idChefAtelier;
    }

    public void setIdChefAtelier(String idChefAtelier) {
        this.idChefAtelier = idChefAtelier;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getIdSection() {
        return idSection;
    }

    public void setIdSection(Integer idSection) {
        this.idSection = idSection;
    }

    public String getIdChefSection() {
        return idChefSection;
    }

    public void setIdChefSection(String idChefSection) {
        this.idChefSection = idChefSection;
    }

    public String getMaterielConsomme() {
        return materielConsomme;
    }

    public void setMaterielConsomme(String materielConsomme) {
        this.materielConsomme = materielConsomme;
    }

    public String getIdOuvrierAffecte() {
        return idOuvrierAffecte;
    }

    public void setIdOuvrierAffecte(String idOuvrierAffecte) {
        this.idOuvrierAffecte = idOuvrierAffecte;
    }

    public String getIdOuvrier() {
        return idOuvrier;
    }

    public void setIdOuvrier(String idOuvrier) {
        this.idOuvrier = idOuvrier;
    }

    public String getEtatTravail() {
        return etatTravail;
    }

    public void setEtatTravail(String etatTravail) {
        this.etatTravail = etatTravail;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

	public Integer getIdBon() {
		return idBon;
	}

	public void setIdBon(Integer idBon) {
		this.idBon = idBon;
	}

}

