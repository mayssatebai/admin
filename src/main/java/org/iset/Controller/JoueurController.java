package org.iset.Controller;

import java.util.List;


import org.iset.Service.JoueurService;
import org.iset.entities.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JoueurController {
	@Autowired	
	JoueurService joueurservice;

	


	public JoueurController(JoueurService joueurservice) {
		super();
		this.joueurservice = joueurservice;
	}

	@GetMapping("/joueur")
	public List<Joueur> getallJoueur(){
		
		return (List<Joueur>) joueurservice.getAll();
		
	}

	@PostMapping("/add-joueur")
	public Joueur addJoeur(@RequestBody Joueur a)
	{
		return joueurservice.addJoeur(a);
		}

	@GetMapping("/joueur/{id}")
	public Joueur getjoueur(@PathVariable Long id )
	{
		return joueurservice.getJoueur(id);}

	@DeleteMapping("/supprim-joueur/{id}")
	public void supprimJoueur(@PathVariable("id") Long id)
	{
		
		joueurservice.delete(id);
	}
	@PostMapping("/modif-joueur")
	public Joueur modifSport(@RequestBody Joueur s )
	{
		return joueurservice.modifjoueur(s);
	}

	


}