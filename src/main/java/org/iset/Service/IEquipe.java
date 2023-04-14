package org.iset.Service;


import java.util.List;

import org.iset.entities.Equipe;


public interface IEquipe {
	List<Equipe> getAllequipe();
	Equipe getEquipe(Long id);
	Equipe addEquipe(Equipe eq);
	void delete(Long id);
	Equipe recherche(Long id_ad);
	Equipe modifEquipe(Equipe eq);

}
