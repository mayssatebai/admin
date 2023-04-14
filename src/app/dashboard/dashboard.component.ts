import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms'
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import {Equipe } from '../../Model/equipe';
import { Match } from '../../Model/match';
import { EquipeService } from '../../Service/equipe-service';
import { MatchService } from '../../Service/match.service';
import *as $ from 'jquery'

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
 

 

  newequipe: Equipe = {
  id: 0, 
  nom: "",
  // niveau:0,
  description:"",
  type:"",
  res:"",
  pari_id:0,
  pari:{
    "id":0
    
  }
  
  }
  
  equipe:any;
  match:any;
 selected:boolean=false;

  constructor(private fb: FormBuilder,private httpClient:HttpClient,private serviceequipe:EquipeService,
      private router:Router,private servicematch:MatchService) {
       
        this.serviceequipe.getAllEquipe().subscribe(data=>{
          this.equipe=data;
          console.log("rr",this.equipe)
      
      } );
      this.servicematch.getAllMatch().subscribe(data=>{
        this.match=data;
        console.log("rr",this.match)
    
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

createequipe(form: any) {
form.value.id = this.newequipe.id;
form.value.nom = this.newequipe.nom;
// form.value.niveau = this.newequipe.niveau;
form.value.description = this.newequipe.description;
form.value.type = this.newequipe.type;
form.value.res = this.newequipe.res;



this.newequipe.pari_id=form.value.pari_id;


if (this.newequipe && this.newequipe.id) {
  this.serviceequipe.Updateequipe2(this.newequipe).subscribe((newequipe: Equipe) => {
    console.log("equipe updated", newequipe);
    this.serviceequipe.getAllEquipe().subscribe((equipe: Equipe[]) => {
      this.equipe = equipe;
      console.log(equipe)
    })
  });
}
else {
  this.serviceequipe.addEquipe(this.newequipe).subscribe((newequipe: Equipe) => {
    console.log("equipe created", newequipe);
   
    console.log("mtc", this.newequipe);
    this.serviceequipe.getAllEquipe().subscribe((equipe: Equipe[]) => {
      this.equipe = equipe;
      console.log(equipe)
    })
  });
}
  


}



clickMethod(id, name) {
if(confirm("Vous etes sur"+name+"?")) {
  this.serviceequipe.onDelete(id).subscribe(data=>{
    console.log(data);
    
    this.serviceequipe.getAllEquipe().subscribe((equipe: Equipe[]) => {
      this.equipe = equipe;
      console.log(equipe)
    })
  })
}
}
selectEquipe(equipe: Equipe) {
this.newequipe = equipe;
console.log("sssss",this.newequipe.id)
}

selectEquipeDetails(equipe: Equipe) {
this.newequipe = equipe;
console.log("sssss",this.newequipe.id)
}




}
