package org.iset.Controller;

import java.util.List;

import org.iset.Service.PanierService;

import org.iset.entities.Panier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PanierController {
	@Autowired
	PanierService panierservice;
	
	
	public PanierController(PanierService professeurservice) {
		super();
		this.panierservice = professeurservice;
	}
	@GetMapping("/professeur")
	@CrossOrigin(origins = "http://localhost:4200")

	public List<Panier> getallpanier(){
		
		return (List<Panier>)panierservice.getAllPanier();
		
	}
	@PostMapping("/add-professeur")
	@CrossOrigin(origins = "http://localhost:4200")

	public Panier addProfesseur(@RequestBody Panier p)
	{
		return panierservice.addPanier(p);
		}
	@GetMapping("/professeur/{id}")
	@CrossOrigin(origins = "http://localhost:4200")

	public Panier getProf(@PathVariable Long id )
	{
		return panierservice.getPanier(id);}
	
	@DeleteMapping("/supprim-professeur/{id}")
	@CrossOrigin(origins = "http://localhost:4200")

	public void supprimProf(@PathVariable("id") Long id )
	{
		panierservice.supprimPanier(id);
	}
	@PostMapping("/modif/professeur")
	@CrossOrigin(origins = "http://localhost:4200")

	public Panier modifPanier(@RequestBody Panier p )
	{
		return panierservice.modifPanier(p);}
}
