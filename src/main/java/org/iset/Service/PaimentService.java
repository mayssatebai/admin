package org.iset.Service;

import java.util.List;

import org.iset.Repositories.PaimentRepository;
import org.iset.entities.Paiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaimentService implements IPaiment{
@Autowired
PaimentRepository inR;
public PaimentService(PaimentRepository inR) {
		super();
		this.inR = inR;
	}
	@Override
	public List<Paiment> getAll()
	{
		return inR.findAll();
	}
	@Override

	public Paiment getPaiment(Long id)
	{
		return inR.findById(id).get();
	}
	@Override
	public void supprimPaiment(Long id) {
		// TODO Auto-generated method stub
		inR.deleteById(id);
	}
	@Override
	public Paiment addPaiment(Paiment i) {
		return inR.save(i);
	}
	@Override
	public Paiment modifPaiment(Paiment i) {
		// TODO Auto-generated method stub
		return inR.save(i);
	}
	
	

}
