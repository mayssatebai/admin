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



@Entity
@Table(name="Parieur")
public class Parieur {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private Long id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="tel")
	private Long tel;
	
	@Column(name="codePostale")
	private Long CodePostale;
	
	@Column(name="ville")
	private String Ville;
	
	@Column(name="compt")
	private boolean Compt;
	
	@ManyToOne
    @JoinColumn(name="admin_id")
    private Admin admin;
	
	
	
	///////////////////////////////////////////////

	@OneToMany(mappedBy = "parieur",orphanRemoval = true)	
	private List<PariChoisi> pari_choisi;
	
	public List<PariChoisi> getPariChoisi() {
		return pari_choisi;
	}

	public void setPariChoisi(List<PariChoisi> pari_choisi) {
		this.pari_choisi = pari_choisi;
	}
///////////////////////////////////////////////
	
	public Parieur(Long id, String nom, String prenom, String email, String password, Long tel, Long codePostale,
			String ville, boolean compt,List<PariChoisi>pari_choisi) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.Compt = compt;
		this.CodePostale = codePostale;
		this.Ville = ville;
		this.pari_choisi=pari_choisi;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Long getTel() {
		return tel;
	}


	public void setTel(Long tel) {
		this.tel = tel;
	}


	public Long getCodePostale() {
		return CodePostale;
	}


	public void setCodePostale(Long codePostale) {
		CodePostale = codePostale;
	}


	public String getVille() {
		return Ville;
	}


	public void setVille(String ville) {
		Ville = ville;
	}

	public boolean getCompt() {
		return Compt;
	}


	public void setCompt(boolean compt) {
		Compt = compt;
	}

	public Parieur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
