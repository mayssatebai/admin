package org.iset.Service;

import java.util.List;

import org.iset.entities.Parieur;

public interface IParieur {
	Parieur addParieur(Parieur e);
	List<Parieur> getAllParieur();
	void supprimParieur(Long id);
	Parieur getParieur(Long id);
	Parieur modifParieur(Parieur e);
}
