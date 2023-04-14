package org.iset.Service;

import java.util.List;

import org.iset.entities.Panier;

public interface IPanier {

	Panier addPanier(Panier p);
	List<Panier> getAllPanier();
	void supprimPanier(Long id);
	Panier getPanier(Long id);
	Panier modifPanier(Panier m);
}
