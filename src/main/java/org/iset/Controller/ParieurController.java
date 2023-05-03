package org.iset.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.iset.Service.ParieurService;
import org.iset.entities.Parieur;
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
public class ParieurController {
@Autowired
ParieurService parieurservice;

public ParieurController(ParieurService parieurservice) {
	super();
	this.parieurservice = parieurservice;
}
@GetMapping("/parieurs")


public List<Parieur> getallParieurs(){
	
	return (List<Parieur>) parieurservice.getAllParieur();
	
}
@PostMapping("/add-parieur")


public Parieur addParieur(@RequestBody Parieur e)
{
	return parieurservice.addParieur(e);
	}


@GetMapping("/parieur/{id}")
public Parieur getParieur(@PathVariable Long id )
{
	return parieurservice.getParieur(id);}


@DeleteMapping("/supprim-parieur/{id}")
public void supprimParieur(@PathVariable("id") Long id)
{
	parieurservice.supprimParieur(id);
	}

@PostMapping("/modif-parieur")
public Parieur modifParieur(@RequestBody Parieur e )
{
	return parieurservice.modifParieur(e);
}

@PostMapping("se_connecter")
public   Parieur seconnecter(@PathParam(value="email") String email,@PathParam(value="password")String password) {
	return parieurservice.seconnecter(email, password);
}
}
