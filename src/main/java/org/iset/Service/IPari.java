package org.iset.Service;

import java.util.Date;
import java.util.List;


import org.iset.entities.Pari;

public interface IPari {
	
	Pari getPari(Long id);
	List<Pari> getAll();
	Pari addPari(Pari ad);
	void delete(Long id);
	Pari recherche(Long id_ad);
	Pari modifPari(Pari ad);
}
