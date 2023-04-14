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

@Entity
@Table(name = "Sport")
public class Sport {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="type")
	private String type;
	
	
	@Column(name="pays")
	private String Pays;
	
	public String getPays() {
		return Pays;
	}
	public void setPays(String pays) {
		Pays = pays;
	}
	@Column(name="description")
	private String description;

    
	@ManyToOne
    @JoinColumn(name="admin_id")
    private Admin admin;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sport")
	private List<Pari> pari;
	
	public List<Pari> getPari() {
		return pari;
	}
	public void setPari(List<Pari> pari) {
		this.pari = pari;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Sport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sport(Long id, String type, String description,List<Pari> pari) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.pari=pari;
	}
	
	
	
}
