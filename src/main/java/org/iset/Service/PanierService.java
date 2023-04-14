package org.iset.Service;

import java.util.List;


import org.iset.Repositories.PanierRepository;
import org.iset.entities.Panier;

import org.springframework.stereotype.Service;

@Service
public class PanierService implements IPanier {
	PanierRepository panier;

	public PanierService(PanierRepository panier) {
		super();
		this.panier =panier;
	}
	@Override
	public Panier addPanier(Panier p)
	{
		return panier.save(p);
	}
	@Override
	public List<Panier> getAllPanier()
	{
		return panier.findAll();
	}
	@Override
	public void supprimPanier(Long id)
	{
		panier.deleteById(id);
	}
	@Override
	public Panier getPanier(Long id)
	{
		return panier.findById(id).get();
	}
	@Override
	public Panier modifPanier(Panier p)
	{
		panier.save(p);
		return p;
	}
	
}
