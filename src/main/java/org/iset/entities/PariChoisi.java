package org.iset.entities;




import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="PariChoisi")
public class PariChoisi {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private Long id;
	
	@Column(name="montant_paye")
	private Long montant_paye;
	
	@Column(name="montant_gagner")
	private float montant_gagner;
	
	@Column(name="choix_pari")
	private String choix_pari;
	
	
	

	

	
	
	

	
	
	/////////////////////////////////////
	@JsonIgnore
	@ManyToOne	
	@JoinColumn(name="pari_id", insertable=false, updatable=false)
	private Pari pari;
	
	@Column(name = "pari_id")
    @JsonProperty("pari_id")
    private Long pari_id;
	 
	
	@JsonIgnore
	@ManyToOne	
	@JoinColumn(name="parieur_id", insertable=false, updatable=false)
	private Parieur parieur;
	
	@Column(name = "parieur_id")
    @JsonProperty("parieur_id")
    private Long parieur_id;
	
	
	public PariChoisi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMontant_paye() {
		return montant_paye;
	}

	public void setMontant_paye(Long montant_paye) {
		this.montant_paye = montant_paye;
	}

	public float getMontant_gagner() {
		return montant_gagner;
	}

	public void setMontant_gagner(float montant_gagner) {
		this.montant_gagner = montant_gagner;
	}
	public String getChoix_pari() {
		return choix_pari;
	}

	public void setChoix_pari(String choix_pari) {
		this.choix_pari = choix_pari;
	}
	
	
	
	public PariChoisi(Long id, Long montant_paye, float montant_gagner,String choix_pari ) {
		super();
		this.id = id;
		this.montant_paye =montant_paye;
		this.montant_gagner =montant_gagner;	
		this.choix_pari=choix_pari;
		
	}

	
	


}
