package org.iset.Service;

import java.util.List;

import org.iset.entities.Admin;


public interface IAdmin {
	List<Admin> getAll();
	Admin addAdmin(Admin ad);
	void delete(Long id);
	Admin recherche(Long id_ad);
	Admin modifAdmin(Admin ad);
}
