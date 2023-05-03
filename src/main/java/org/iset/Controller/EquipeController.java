package org.iset.Controller;



import java.util.List;

import org.iset.Service.EquipeService;
import org.iset.entities.Equipe;
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
public class EquipeController {
	@Autowired	
	EquipeService equipeService;

	@GetMapping("/equipe")
	public List<Equipe> getallequipe(){
		
		return (List<Equipe>) equipeService.getAllequipe();
		
	}
	@PostMapping("/add-equipe")
	public Equipe addEquipe(@RequestBody Equipe  a)
	{
		return equipeService.addEquipe(a);
		}

	@GetMapping("/equipe/{id}")
	public Equipe addEquipe(@PathVariable Long id )
	{
		return equipeService.recherche(id);}

	@DeleteMapping("/supprim-equipe/{id}")
	public void supprimEquipe(@PathVariable("id") Long id)
	{
		
		equipeService.delete(id);
	}

	@PostMapping("/modifEquipe")
	public Equipe modifEquipe(@RequestBody Equipe a )
	{
		return equipeService.modifEquipe(a);
	}

   

}
