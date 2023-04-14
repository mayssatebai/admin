import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import {Parieur } from '../../Model/parieur';

import { ParieurService } from '../../Service/parieur-service';

import *as $ from 'jquery'

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  // newsport =new Sport();
  newparieur: Parieur = {
		id: 0, 
		nom: "",
    prenom:"",
    email:"",
    tel:"",
    ville:"",
    codePostale:0,
    compt:false

	}
  parieur:any;

 
  
  constructor(private httpClient:HttpClient,private serviceparieur:  ParieurService,
    private router:Router) { }
 
  ngOnInit(): void {
    this.serviceparieur.getAllParieur().subscribe(data=>{
      this.parieur=data;

  } 
  
  );
  
  

}


edit(form: any) {
 
  form.value.compt = this.newparieur.compt;
  
  if (this.newparieur && this.newparieur.id) {
    this.serviceparieur.Updatepar2(this.newparieur).subscribe((newparieur: Parieur) => {
      console.log("parieur updated", newparieur);
      this.serviceparieur.getAllParieur().subscribe((parieur: Parieur[]) => {
        this.parieur = parieur;
        console.log(parieur)
      })
    });
  }
 
  }
  
clickMethod(id, name) {
  if(confirm("Vous etes sur"+name+"?")) {
    this.serviceparieur.onDelete(id).subscribe(data=>{
      console.log(data);
      
      this.ngOnInit();
    })
  }
}
selectParieur(parieur: Parieur) {
  this.newparieur = parieur;
  console.log("sssss",this.newparieur.id)
}

selectParieurDetails(parieur: Parieur) {
  this.newparieur = parieur;
  console.log("sssss",this.newparieur.id)
  }
  select(parieur: Parieur) {
    this.newparieur = parieur;
    console.log("sssss2",parieur.id)
    if(this.newparieur.id=parieur.id){
      this.serviceparieur.Updatepar2(this.newparieur).subscribe((newparieur: Parieur) => {
        console.log("parieur updated", newparieur);
        
      });
    }
    }
 

public onSaveUsernameChanged(value:boolean){
    this.newparieur.compt = value;
  
    // this.newparieur = parieur;
    console.log("val",value)

   
  
}
trackByFn(index, item) {
  return index;
}
 
}
