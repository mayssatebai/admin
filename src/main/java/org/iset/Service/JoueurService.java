package org.iset.Service;

import java.util.List;


import org.iset.Repositories.JoueurRepository;
import org.iset.entities.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class JoueurService implements IJoueur {
	@Autowired	
	JoueurRepository  adR;


public JoueurService(JoueurRepository adR) {
		super();
		this.adR = adR;
	}
@Override
public Joueur getJoueur(Long id)
{
	return adR.findById(id).get();
}
@Override
public List<Joueur> getAll()
{
	return adR.findAll();
}

@Override
public Joueur addJoeur(Joueur jo)
{
	return adR.save(jo);
}
@Override
public void delete(Long id)
{
adR.deleteById(id);
}

@Override
public Joueur modifjoueur(Joueur jo)
{
	 adR.save(jo);
	 return jo;
}
@Override
public Joueur recherche(Long id_jo)
{
	return adR.findById(id_jo).get();
}

}


