package com.santeservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mesures_medicales")
public class MesuresMedicale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMesure;

    private LocalDate dateMesure;

    public LocalDate getDateMesure() {
		return dateMesure;
	}

	public void setDateMesure(LocalDate dateMesure) {
		this.dateMesure = dateMesure;
	}

	private Float poids;
    private Float taille;
    private String tensionArterielle;
    private Integer pouls;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "numero_dossier")
    private DossierMedical dossierMedical;

	public Integer getIdMesure() {
		return idMesure;
	}

	public void setIdMesure(Integer idMesure) {
		this.idMesure = idMesure;
	}

	

	public Float getPoids() {
		return poids;
	}

	public void setPoids(Float poids) {
		this.poids = poids;
	}

	public Float getTaille() {
		return taille;
	}

	public void setTaille(Float taille) {
		this.taille = taille;
	}

	public String getTensionArterielle() {
		return tensionArterielle;
	}

	public void setTensionArterielle(String tensionArterielle) {
		this.tensionArterielle = tensionArterielle;
	}

	public Integer getPouls() {
		return pouls;
	}

	public void setPouls(Integer pouls) {
		this.pouls = pouls;
	}

	public DossierMedical getDossierMedical() {
		return dossierMedical;
	}

	public void setDossierMedical(DossierMedical dossierMedical) {
		this.dossierMedical = dossierMedical;
	}

    // Getters & Setters
    
    
}

