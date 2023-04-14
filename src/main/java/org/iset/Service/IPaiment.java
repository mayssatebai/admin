package org.iset.Service;

import java.util.List;

import org.iset.entities.Paiment;

public interface IPaiment {
	List<Paiment> getAll();
	Paiment getPaiment(Long id);
	void supprimPaiment(Long id);
	Paiment addPaiment(Paiment i);
	Paiment modifPaiment(Paiment i);
	

}
