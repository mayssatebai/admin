package org.iset.Service;


import java.util.List;

import org.iset.Repositories.PariRepository;
import org.iset.entities.Pari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class PariService implements IPari{
	@Autowired	
	PariRepository adR;

	
	@Override
	public Pari getPari(Long id)
	{
		return adR.findById(id).get();
	}
	@Override
	public List<Pari> getAll()
	{  
		return adR.findAll();
	}
	public PariService(PariRepository adR) {
		super();
		this.adR = adR;
	}
	@Override
	public Pari addPari(Pari ad)
	{
		return adR.save(ad);
	}
	@Override
	public void delete(Long id)
	{
	adR.deleteById(id);
	}

	@Override
	public Pari modifPari(Pari ad)
	{
		 adR.save(ad);
		 return ad;
	}
	@Override
	public Pari recherche(Long id_ad)
	{
		return adR.findById(id_ad).get();
	}
	
}

