package com.techservice.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_section")
    private Integer idSection;

    @Column(name = "nom_section")
    private String nomSection;

    public Section() {}

    public Integer getIdSection() { return idSection; }
    public void setIdSection(Integer idSection) { this.idSection = idSection; }

    public String getNomSection() { return nomSection; }
    public void setNomSection(String nomSection) { this.nomSection = nomSection; }

}
