package org.iset.Controller;

import java.util.List;

import org.iset.Service.PaimentService;

import org.iset.entities.Paiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class PaimentController {
	@Autowired
PaimentService inS;

	public PaimentController(PaimentService inS) {
		super();
		this.inS = inS;
	}
	@GetMapping("/interventions")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Paiment> getAll()
	{
		return inS.getAll();
	}
	@PostMapping("/add-inter")
	@CrossOrigin(origins = "http://localhost:4200")
	public Paiment addInter(@RequestBody Paiment i)
	{
		return inS.addPaiment(i);
	}

	
	
	@DeleteMapping("/supprim-inter/{id}")
	@CrossOrigin(origins = "http://localhost:4200")

	public void supprimPaiment(@PathVariable Long id)
	{
		inS.supprimPaiment(id);
	}
	@GetMapping("/intervention/{id}")
	@CrossOrigin(origins = "http://localhost:4200")

	public Paiment getPaiment(@PathVariable Long id)
	{
		return inS.getPaiment(id);
	}
	@PutMapping("/modif-inter")
	@CrossOrigin(origins = "http://localhost:4200")

	public Paiment modifPaiment(@RequestBody Paiment i)
	{
		return inS.modifPaiment(i);
	}
}
