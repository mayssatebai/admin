package org.iset.Service;

import java.util.List;

import org.iset.Repositories.ParieurRepository;
import org.iset.entities.Parieur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParieurService  implements IParieur {
	@Autowired	
	ParieurRepository etR;

	public ParieurService(ParieurRepository etR) {
		super();
		this.etR = etR;
	}
	@Override
	public Parieur addParieur(Parieur e)
	{
		return etR.save(e);
	}
	@Override
	public List<Parieur> getAllParieur()
	{
		return etR.findAll();
	}
	@Override
	public void supprimParieur(Long id)
	{
		etR.deleteById(id);
	}
	@Override
	public Parieur getParieur(Long id)
	{
		return etR.findById(id).get();
	}
	@Override
	public Parieur modifParieur(Parieur e)
	{
		 etR.save(e);
		 return e;
	}
	public Parieur seconnecter( String email ,String password ) {
		return etR.seconnecter(email, password);
	}
}
