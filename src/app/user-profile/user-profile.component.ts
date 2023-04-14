import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import {Parieur } from '../../Model/parieur';
import { Paiment } from '../../Model/paiment';

import { PaiementService } from '../../Service/paiement';
import { ParieurService } from '../../Service/parieur-service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  // newsport =new Sport();
  newparieur: Paiment = {
		id: 0, 
		nompar: "",
    prenompar:"",
    emailpar:"",
    date_paiment:new Date,
    montant_gagner:"",
    montant_total:"",
    type:""

	}
  paiement:any;

 
  
  constructor(private httpClient:HttpClient,private serviceparieur:  ParieurService,
    private router:Router,private servicepaiement: PaiementService) { }
 
  ngOnInit(): void {
    this.servicepaiement.getAllPaiement().subscribe(data=>{
      this.paiement=data;

  } 
  
  );
  
  

}


  
clickMethod(id, name) {
  if(confirm("Vous etes sur de supprimer "+name+"?")) {
    this.servicepaiement.onDelete(id).subscribe(data=>{
      console.log(data);
      
      this.ngOnInit();
    })
  }
}
selectParieur(parieur: Paiment) {
  this.newparieur = parieur;
  console.log("sssss",this.newparieur.id)
}

selectPaiementDetails(parieur: Paiment) {
  this.newparieur = parieur;
  console.log("sssss",this.newparieur.id)
  }
  // select(parieur: Paiment) {
  //   this.newparieur = parieur;
  //   console.log("sssss2",parieur.id)
  //   if(this.newparieur.id=parieur.id){
  //     this.servicepaiement.Updatepaiement2(this.newparieur).subscribe((newparieur: Paiment) => {
  //       console.log("parieur updated", newparieur);
        
  //     });
  //   }
  //   }
 

// public onSaveUsernameChanged(value:boolean){
//     this.newparieur.compt = value;
  
//     // this.newparieur = parieur;
//     console.log("val",value)

   
  
// }
 
}
