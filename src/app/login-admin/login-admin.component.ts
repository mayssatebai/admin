import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Admin } from '../../Model/admin';
import { AdminServiceService } from '../../Service/admin-service';


@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {


  admin = new Admin();
  erreur=0;
  
  constructor(private AdminServiceService:AdminServiceService,
    private router: Router) { }
  ngOnInit(): void {
  }
  onSubmit(f: NgForm)
  {
  
  let isValidUser: Boolean = this.AdminServiceService.SignIn(this.admin);
 if (isValidUser)
 this.router.navigate(['/sport']);
 else
 alert('Email ou mot de passe incorrecte!');
 }
}
