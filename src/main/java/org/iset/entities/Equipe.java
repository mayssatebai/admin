package org.iset.entities;



import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="Equipe")
public class Equipe {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private Long id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="niveau")
	private int niveau;
	
	@Column(name="description")
	private String description;
	
	@Column(name="type")
	private String type;
	

	@Column(name="res")
	private String res;
	
	
	
	 public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Pari getPari() {
		return pari;
	}
	public void setPari(Pari pari) {
		this.pari = pari;
	}
	
	@JsonIgnore
	@ManyToOne	
	@JoinColumn(name="pari_id", insertable=false, updatable=false)
	private Pari pari;
	
	@Column(name = "pari_id")
    @JsonProperty("pari_id")
    private Long pari_id;
	 
	
	@OneToMany(mappedBy = "equipe")	
	@JsonIgnore
	private List<Joueur> joueur;
	
	public List<Joueur> getJoueur() {
		return joueur;
	}
	public void setJoueur(List<Joueur> joueur) {
		this.joueur = joueur;
	}
	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Equipe(String nom, int niveau, String description, String type, String res) {

	}
	public Equipe(Long id, String nom, int niveau, String description, String type,String resulats,List<Joueur>joueur) {
		super();
		this.id = id;
		this.nom = nom;
		this.niveau = niveau;
		this.description = description;
		this.type = type;
		res = resulats;
		this.joueur=joueur;
		
		}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getRes() {
		return res;
	}
	public void setRes(String resulats) {
		res = resulats;
	}
	
	 

}
