import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import { Sport } from '../../Model/sport';
import { MatchService } from '../../Service/match.service';
import *as $ from 'jquery'
@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css']
})
export class TableListComponent implements OnInit {
  sports: Sport[] = [];
  genre;
  // newsport =new Sport();
  newsport: Sport = {
		id: 0, 
		type: "",
    description:"",
    pays:""

	}
  sport:any;

  ajout:boolean=false;
  id: number;
  
  constructor(private httpClient:HttpClient,private servicematch:  MatchService,
    private router:Router) { }

    ngOnInit(): void {
      this.servicematch.getAllSport().subscribe(data=>{
        this.sport=data;
  
    } 
    
    );
    
    
  
  }
  Edit(id) {
   
    this.servicematch.Updatesport(id).subscribe((res: any) => {
      console.log("edit fn", id)
      this.genre = res;
      
    })
  }
  createsport(form: any) {
    form.value.id = this.newsport.id;
    form.value.type = this.newsport.type;
    form.value.description = this.newsport.description;
    form.value.pays = this.newsport.pays;
  
  
    if (this.newsport && this.newsport.id) {
      this.servicematch.Updatesport(form.value).subscribe((sport: Sport) => {
        console.log("sport updated", sport);
        this.servicematch.getAllSport().subscribe((sport: Sport[]) => {
          this.sport = sport;
  
          console.log(sport)
        })
      });
    }
    else {
      this.servicematch.creatSport(form.value).subscribe((sport: Sport) => {
        
        console.log("sport created, ", sport);
  
        this.servicematch.getAllSport().subscribe((sport: Sport[]) => {
          this.sport = sport;
        })
        
  
        // this.apiService.readNiveau().subscribe((niveaux: Niveau[])=>{
        // 	this.niveaux = niveaux;
  
        // 	 });
      });
  
  
    }
  
  
  }
  // onSubmitt(f: NgForm) {
           
  //   console.log(this.newsport);
  //   this.servicematch.addSport(this.newsport);  
  //   window.alert("sport est ajouté !");
  //   this.router.navigate(['listeSports']);
  //   isAdded:true;
  
   
  //  }
  //  onSubmit() {
  
   
  //   this.servicematch.addSport(this.newsport).subscribe(
  //     data => {
  //       if (data) {
  
  //       }
  
  
  //     },
  //     err => {
  //       console.log("error sending data")
  //     },
  //     () => {
  //       alert("Confirmez?")
  //       console.log("data sent")
  //     }
  
  
  
  //   )
  
  // }
  clickMethod(id, name) {
    if(confirm("Vous etes sur"+name+"?")) {
      this.servicematch.onDelete(id).subscribe(data=>{
        console.log(data);
        
        this.ngOnInit();
      })
    }
  }
  selectSport(sport: Sport) {
    this.newsport = sport;
    console.log("sssss",this.newsport.id)
  }
  Updatesport(id: number){
    this.router.navigate(['update_sport',id]) ;
  
   }
   plus_de_detailes(id : number){
     this.router.navigate(['sport',id])
   
   }

   selectSportDetails(sport: Sport) {
    this.newsport = sport;
    console.log("sssss", this.newsport.id)
  }

}
