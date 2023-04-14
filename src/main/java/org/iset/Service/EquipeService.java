package org.iset.Service;

import java.util.List;

import org.iset.Repositories.EquipeRepository;
import org.iset.entities.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipeService  implements IEquipe{
	@Autowired	
		EquipeRepository  adR;
	
	@Override
	public Equipe getEquipe(Long id)
	{
		return adR.findById(id).get();
	}
	@Override
	public List<Equipe> getAllequipe()
	{
		return adR.findAll();
	}

	@Override
	public Equipe addEquipe(Equipe ad)
	{
		return adR.save(ad);
	}
	@Override
	public void delete(Long id)
	{
	adR.deleteById(id);
	}

	@Override
	public Equipe modifEquipe(Equipe ad)
	{
		 adR.save(ad);
		 return ad;
	}
	@Override
	public Equipe recherche(Long id_eq)
	{
		return adR.findById(id_eq).get();
	}
	
}
