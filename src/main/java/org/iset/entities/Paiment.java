package org.iset.entities;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Paiment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date_paiment;
	private String type;
	private String nompar;
	private String prenompar;
	private String emailpar;
	private String montant_total;
	private String montant_gagner;

	public Paiment(Long id, Date date_paiment, String type, String nompar, String prenompar, String emailpar,
			String montant_total, String montant_gagner) {
		super();
		this.id = id;
		this.date_paiment = date_paiment;
		this.type = type;
		this.nompar = nompar;
		this.prenompar = prenompar;
		this.emailpar = emailpar;
		this.montant_total = montant_total;
		this.montant_gagner = montant_gagner;
	}




	public String getMontant_total() {
		return montant_total;
	}




	public void setMontant_total(String montant_total) {
		this.montant_total = montant_total;
	}




	public String getMontant_gagner() {
		return montant_gagner;
	}




	public void setMontant_gagner(String montant_gagner) {
		this.montant_gagner = montant_gagner;
	}




	public Paiment(Long id, Date date_paiment, String type, String nompar, String prenompar, String emailpar) {
		super();
		this.id = id;
		this.date_paiment = date_paiment;
		this.type = type;
		this.nompar = nompar;
		this.prenompar = prenompar;
		this.emailpar = emailpar;
	}




	public String getNompar() {
		return nompar;
	}




	public void setNompar(String nompar) {
		this.nompar = nompar;
	}




	public String getPrenompar() {
		return prenompar;
	}




	public void setPrenompar(String prenompar) {
		this.prenompar = prenompar;
	}




	public String getEmailpar() {
		return emailpar;
	}




	public void setEmailpar(String emailpar) {
		this.emailpar = emailpar;
	}




	public Paiment() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Date getDate_paiment() {
		return date_paiment;
	}




	public void setDate_paiment(Date date_paiment) {
		this.date_paiment = date_paiment;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public Paiment(Long id, Date date_paiment, String type) {
		super();
		this.id = id;
		this.date_paiment = date_paiment;
		this.type = type;
	}



	
}
