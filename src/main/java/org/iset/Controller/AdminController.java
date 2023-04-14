package org.iset.Controller;

import java.util.List;

import org.iset.Service.AdminService;
import org.iset.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AdminController {
@Autowired	
AdminService adminService;

public AdminController(AdminService adminService) {
	super();
	this.adminService = adminService;
}


@GetMapping("/admins")
public List<Admin> getalladmin(){
	
	return (List<Admin>) adminService.getAll();
	
}

@PostMapping("/add-admin")
public Admin addAdmin(@RequestBody Admin a)
{
	return adminService.addAdmin(a);
	}

@GetMapping("/admin/{id}")
public Admin getAdd(@PathVariable Long id )
{
	return adminService.recherche(id);}

@DeleteMapping("/supprim-admin/{id}")
public void supprimAdmin(@PathVariable("id") Long id)
{
	
	adminService.delete(id);
}

@PostMapping("/modif")
public Admin modifAdmin(@RequestBody Admin a )
{
	return adminService.modifAdmin(a);}
}
