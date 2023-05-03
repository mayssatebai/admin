package org.iset.Controller;



import java.util.List;

import org.iset.Service.PariChoisiService;
import org.iset.entities.PariChoisi;
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

public class PariChoisiController {
	@Autowired	
	PariChoisiService parichoisiService;

	@GetMapping("/PariChoisi")
	public List<PariChoisi> getallPariChoisi(){
		
		return (List<PariChoisi>) parichoisiService.getAllparichoisi();
		
	}
	@PostMapping("/add-PariChoisi")
	public PariChoisi addPariChoisi(@RequestBody PariChoisi  a)
	{
		return parichoisiService.addPariChoisi(a);
		}

	@GetMapping("/PariChoisi/{id}")
	public PariChoisi addPariChoisi(@PathVariable Long id )
	{
		return parichoisiService.recherche(id);}

	@DeleteMapping("/supprim-PariChoisi/{id}")
	public void supprimPariChoisi(@PathVariable("id") Long id)
	{
		
		parichoisiService.delete(id);
	}

	@PostMapping("/modifPariChoisi")
	public PariChoisi modifPariChoisi(@RequestBody PariChoisi a )
	{
		return parichoisiService.modifPariChoisi(a);
	}

   

}
