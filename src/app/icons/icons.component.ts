import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms'
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import {Equipe } from '../../Model/equipe';
import { Joueur } from '../../Model/joueur';
import { EquipeService } from '../../Service/equipe-service';
import { JoueurService } from '../../Service/joueur-service';
import *as $ from 'jquery'
@Component({
  selector: 'app-icons',
  templateUrl: './icons.component.html',
  styleUrls: ['./icons.component.css']
})
export class IconsComponent implements OnInit {

 
  newjoueur: Joueur = {
  id: 0, 
  nom: "",
  // niveau:0,
  prenom:"",
  numero:0,
  poste:"",
  grade:"",
  equipe:{
    "id":0
    
  }
  
  }
  
  equipe:any;
  joueur:any;
 

  constructor(private fb: FormBuilder,private httpClient:HttpClient,private serviceequipe:EquipeService,
      private router:Router,private servicejoueur:JoueurService) {
       
        this.serviceequipe.getAllEquipe().subscribe(data=>{
          this.equipe=data;
          console.log("rr",this.equipe)
      
      } );
      this.servicejoueur.getAllJoueur().subscribe(data=>{
        this.joueur=data;
        console.log("rr",this.joueur)
    
    } );
       }
 
ngOnInit(): void {


}
// Edit(id) {

// this.servicematch.Updatesport(id).subscribe((res: any) => {
//   console.log("edit fn", id)
//   this.genre = res;
  
// })
// }

createjoueur(form: any) {
form.value.id = this.newjoueur.id;
form.value.nom = this.newjoueur.nom;
 
form.value.prenom = this.newjoueur.prenom;
form.value.grade = this.newjoueur.grade;
form.value.poste = this.newjoueur.poste;




this.newjoueur.equipe.id=Number(form.value.equipe);


if (this.newjoueur && this.newjoueur.id) {
  this.servicejoueur.Updatejoueur2(this.newjoueur).subscribe((newjoueur: Joueur) => {
    console.log("joueur updated", newjoueur);
    this.servicejoueur.getAllJoueur().subscribe((joueur: Joueur[]) => {
      this.joueur = joueur;
      console.log(joueur)
    })
  });
}
else {
  this.servicejoueur.addJoueur(this.newjoueur).subscribe((newjoueur: Joueur) => {
    console.log("joueur created", newjoueur);
   
    console.log("mtc", this.newjoueur);
    this.servicejoueur.getAllJoueur().subscribe((joueur: Joueur[]) => {
      this.joueur = joueur;
      console.log(joueur)
    })
  });
}
  


}



clickMethod(id, name) {
if(confirm("Vous etes sur de supprimer "+name+"?")) {
  this.servicejoueur.onDelete(id).subscribe(data=>{
    console.log(data);
    
    this.servicejoueur.getAllJoueur().subscribe((joueur: Joueur[]) => {
      this.joueur = joueur;
      console.log(joueur)
    })
  })
}
}
selectJoueur(joueur: Joueur) {
this.newjoueur = joueur;
console.log("sssss",this.newjoueur.id)
}

selectJoueurDetails(joueur: Joueur) {
this.newjoueur = joueur;
console.log("sssss",this.newjoueur.id)
}




}
