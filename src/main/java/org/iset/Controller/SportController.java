package org.iset.Controller;


import java.util.List;

import org.iset.Service.SportService;
import org.iset.entities.Parieur;
import org.iset.entities.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin()

public class SportController {
	@Autowired
	SportService sportservice;

	public SportController(SportService sportservice) {
		super();
		this.sportservice = sportservice;
	}
	@GetMapping("/sports")


	public List<Sport> getallSport(){
		
		return (List<Sport>) sportservice.getAllSport();
		
	}
	@PostMapping("/add-Sport")


	public Sport addSport(@RequestBody Sport s)
	{
		return sportservice.addSport(s);
		}
	
	@GetMapping("/sport/{id}")


	public Sport getSport(@PathVariable Long id )
	{
		return sportservice.getSport(id);}
	
	
	@DeleteMapping("/supprim-sport/{id}")


	public void supprimSport(@PathVariable("id") Long id)
	{
		sportservice.supprimSport(id);
	}
	@PostMapping("/modif-sport")
	public Sport modifSport(@RequestBody Sport s )
	{
		return sportservice.modifSport(s);
	}

}
