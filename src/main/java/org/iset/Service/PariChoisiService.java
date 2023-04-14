package org.iset.Service;

import java.util.List;

import org.iset.Repositories.PariChoisiRepository;
import org.iset.entities.PariChoisi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PariChoisiService  implements IPariChoisi{
	@Autowired	
	PariChoisiRepository  adR;
	
	@Override
	public PariChoisi getPariChoisi(Long id)
	{
		return adR.findById(id).get();
	}
	@Override
	public List<PariChoisi> getAllparichoisi()
	{
		return adR.findAll();
	}

	@Override
	public PariChoisi addPariChoisi(PariChoisi ad)
	{
		return adR.save(ad);
	}
	@Override
	public void delete(Long id)
	{
	adR.deleteById(id);
	}

	@Override
	public PariChoisi modifPariChoisi(PariChoisi ad)
	{
		 adR.save(ad);
		 return ad;
	}
	@Override
	public PariChoisi recherche(Long id_eq)
	{
		return adR.findById(id_eq).get();
	}
	
}
