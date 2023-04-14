package org.iset.entities;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Pari")
public class Pari {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private Long id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="temp_deb")
	private String temp_deb;
	
	@Column(name="temp_fin")
	private String temp_fin;
	
	
	

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	@Column(name="date_Match")
	private  Date date_match;
	
	public Date getDate_match() {
		return date_match;
	}

	public void setDate_match(Date date_match) {
		this.date_match = date_match;
	}

	@Column(name="pari_montant")
	private String pari_montant;
	
	@Column(name="resultat")
	private String resultat;
	 
	//@JsonIgnore
	 @ManyToOne
	 private Sport sport;
	 
	 //@JsonIgnore
	@OneToMany(mappedBy = "pari",orphanRemoval = true)
			
	private List<Equipe> equipe;
	

	 //@JsonIgnore
	@OneToMany(mappedBy = "pari",orphanRemoval = true)			
	private List<PariChoisi> pari_choisi;
	 
	

	

	public List<PariChoisi> getPariChoisi() {
		return pari_choisi;
	}

	public void setPariChoisi(List<PariChoisi> pari_choisi) {
		this.pari_choisi = pari_choisi;
	}
	
	
	
	public List<Equipe> getEquipe() {
		return equipe;
	}

	public void setEquipe(List<Equipe> equipe) {
		this.equipe = equipe;
	}

	public Pari() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPari_montant() {
		return pari_montant;
	}

	public void setPari_montant(String pari_montant) {
		this.pari_montant = pari_montant;
	}
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
	public Pari(Long id, String nom, String temp_deb, String temp_fin, String pari_montant,String resultat, Date date_match,List<Equipe>equipe,List<PariChoisi>pari_choisi) {
		super();
		this.id = id;
		this.nom = nom;
		this.temp_deb = temp_deb;
		this.temp_fin = temp_fin;
		this.pari_montant = pari_montant;
		this.date_match=date_match;
		this.resultat=resultat;
		this.equipe=equipe;
		this.pari_choisi=pari_choisi;
	}

	public String getTemp_deb() {
		return temp_deb;
	}

	public void setTemp_deb(String temp_deb) {
		this.temp_deb = temp_deb;
	}

	public String getTemp_fin() {
		return temp_fin;
	}

	public void setTemp_fin(String temp_fin) {
		this.temp_fin = temp_fin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	


}
