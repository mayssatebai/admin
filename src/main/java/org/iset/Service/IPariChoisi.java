package org.iset.Service;


import java.util.List;

import org.iset.entities.PariChoisi;


public interface IPariChoisi {
	List<PariChoisi> getAllparichoisi();
	PariChoisi getPariChoisi(Long id);
	PariChoisi addPariChoisi(PariChoisi eq);
	void delete(Long id);
	PariChoisi recherche(Long id_ad);
	PariChoisi modifPariChoisi(PariChoisi eq);

}