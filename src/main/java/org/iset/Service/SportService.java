package org.iset.Service;

import java.util.List;

import org.iset.Repositories.SportRepository;
import org.iset.entities.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SportService implements ISport {
	@Autowired
SportRepository sp;

	public SportService(SportRepository sp) {
		super();
		this.sp = sp;
	}


	
	@Override
	public Sport addSport(Sport s)
	{
		return sp.save(s);
	}
	@Override

	public List<Sport> getAllSport()
	{
		return sp.findAll();
	}

	@Override
	public void supprimSport(Long id)
	{
		sp.deleteById(id);
	}

	@Override
	public Sport getSport(Long id)
	{
		return sp.findById(id).get();
	}

	@Override
	public Sport modifSport(Sport s)
	{
		 sp.save(s);
		 return s;
	}


}
