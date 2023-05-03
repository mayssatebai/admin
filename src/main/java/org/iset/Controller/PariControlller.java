package org.iset.Controller;


import java.util.List;

import org.iset.Service.PariService;
import org.iset.entities.Pari;
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
public class PariControlller {
	@Autowired	
	PariService pariService;

	

	public PariControlller(PariService pariService) {
		super();
		this.pariService = pariService;
	}

	@GetMapping("/paris")
	public List<Pari> getallpari(){
		
		return (List<Pari>) pariService.getAll();
		
	}

	@PostMapping("/add-pari")
	public Pari addPari(@RequestBody Pari a)
	{
		return pariService.addPari(a);
		
	}

	@GetMapping("/pari/{id}")
	public Pari getAdd(@PathVariable Long id )
	{
		return pariService.recherche(id);}

	@DeleteMapping("/supprim-pari/{id}")
	public void supprimPari(@PathVariable("id") Long id)
	{
		
		pariService.delete(id);
	}

	@PostMapping("/modifpari")
	public Pari modifPari(@RequestBody Pari a )
	{
		return pariService.modifPari(a);
	}

   
}