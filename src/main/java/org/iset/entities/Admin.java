package org.iset.entities;


import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Admin")

public class Admin {
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
	
	 @OneToMany(mappedBy="admin")
	    private List<Sport> sports;
	 
	 @OneToMany(mappedBy="admin")
	    private List<Parieur> parieurs;
	 
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public long gettel() {
		return tel;
	}
	public void setNtel(long tel) {
		this.tel = tel;
	}


	public Admin(Long id, String nom, String email, String password, long tel, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom=prenom;
		this.email = email;
		this.password = password;
		this.tel = tel;
	}
	public Admin(Long id, String nom,String prenom, String email, String password, long tel) {
		super();
		this.id = id;
		this.nom= nom;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.prenom=prenom;
	
	

}
}
