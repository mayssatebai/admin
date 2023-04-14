package org.iset.Service;

import java.util.List;

import org.iset.entities.Sport;

public interface ISport {
	Sport addSport(Sport m);
	List<Sport> getAllSport();
	void supprimSport(Long id);
	Sport getSport(Long id);
	Sport modifSport(Sport m);
}
