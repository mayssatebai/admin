package org.iset.Service;

import java.util.List;


import org.iset.entities.Joueur;


public interface IJoueur {
	Joueur getJoueur(Long id);
	List<Joueur> getAll();
	Joueur addJoeur(Joueur jo);
	void delete(Long id);
	Joueur recherche(Long id_jo);
	Joueur modifjoueur(	Joueur jo);
}
