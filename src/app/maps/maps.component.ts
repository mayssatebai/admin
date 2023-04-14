import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms'
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import { Sport } from '../../Model/sport';
import { Match } from '../../Model/match';
import { PariChoisi } from '../../Model/parichoisi';
import { MatchService } from '../../Service/match.service';
import { PariChoisiService } from '../../Service/parichoisi-service';
import *as $ from 'jquery'


@Component({
  selector: 'app-maps',
  templateUrl: './maps.component.html',
  styleUrls: ['./maps.component.css']
})
export class MapsComponent implements OnInit {


  sports: Sport[] = [];
  pars: Match[] = [];
  genre;
  submitted = false;
  success = false;
  selected = false;
  sport_scl: string = "";

  // newsport =new Sport();
  newsport: Sport = {
    id: 0,
    type: "",
    description: "",
    pays: ""

  }
  newmatch: Match = {
    id: 0,
    nom: "",
    date_match: new Date(),
    temp_deb: "",
    temp_fin: "",
    pari_montant: "",
    resultat: "",
    sport: {
      "id": 0

    },
    PariChoisi: {
      "id": 0,
      "montant_gagner": 0

    }
  }
  newparichoisi: PariChoisi = {
    id: 0,
    montant_paye: 0,
    montant_gagner: 0,
    pari_id: 0,
    parieur_id: 0,
    choix_pari: ""




  }
  sport: any;
  match: any;
  parichoisi: any;
  ajout: boolean = false;
  id: number;
  form: FormGroup;

  constructor(private fb: FormBuilder, private httpClient: HttpClient, private servicematch: MatchService, private serviceparichoisi: PariChoisiService,
    private router: Router) {

    this.servicematch.getAllSport().subscribe(data => {
      this.sport = data;
      console.log("rr", this.sport)

    });
    this.servicematch.getAllMatch().subscribe(data => {
      this.match = data;
      console.log("rr", this.match)

    });
  }

  ngOnInit(): void {
    //   this.servicematch.getAllMatch().subscribe(data=>{
    //     this.match=data;
    //     console.log("match",this.match)

    // } 


    // );
    //   this.servicematch.getAllSport().subscribe(data=>{
    //     this.sport=data;
    //     console.log("sport",this.sport)


    // } );



  }
  Edit(id) {

    this.servicematch.Updatesport(id).subscribe((res: any) => {
      console.log("edit fn", id)
      this.genre = res;

    })
  }

  creatematch(form: any) {
    form.value.id = this.newmatch.id;
    form.value.nom = this.newmatch.nom;
    form.value.date_match = this.newmatch.date_match;
    form.value.temp_deb = this.newmatch.temp_deb;
    form.value.temp_fin = this.newmatch.temp_fin;
    form.value.pari_montant = this.newmatch.pari_montant;
    //  form.value.montant_gagner=this.newmatch.PariChoisi.montant_gagner;


    let p = Number(this.newmatch.sport.id);

    //  this.newmatch.sport.push({
    //  id: p.id,

    // })
    console.log("p", p);


    this.newmatch.sport.id = Number(form.value.sport);

    // let sport = this.form.value.sport;
    // let niv = this.form.value;
    // delete niv['sport'];
    // console.log("ssa",sport);
    // console.log("ssp",niv);

    this.servicematch.getAllMatch().subscribe((match: Match[]) => {
      this.match = match;
      console.log(match)





    });
    this.serviceparichoisi.getAllPariChoisi().subscribe((parichoisi: PariChoisi[]) => {
      console.log("match updated", parichoisi);
      this.parichoisi = parichoisi;

      for (let i = 0; i < this.match.length; i++) {
        for (let j = 0; j < this.parichoisi.length; j++) {
          if (this.match[i].id == this.parichoisi[j].pari_id) {
            if (this.match[i].resultat == this.parichoisi[j].choix_pari) {
              this.parichoisi[j].montant_gagner = this.match[i].pari_montant * parichoisi[j].montant_paye;
              console.log("montant gagner", this.parichoisi[j].montant_gagner)
              console.log("parid_id", this.parichoisi[j].pari_id)
              console.log("match_id", this.match[i].id)

              //  this.newparichoisi.montant_gagner=form.value.montant_gagner;
              //  this.newparichoisi.id=form.value.id;
              //  this.newmatch.PariChoisi.montant_gagner=this.newparichoisi[j].montant_gagner
              if (this.parichoisi[j] && this.parichoisi[j].pari_id == this.match[i].id) {
                this.serviceparichoisi.UpdatePariChoisi2(this.parichoisi[j]).subscribe((newPariChoisi: PariChoisi) => {
                  console.log("pariChoiis updated", newPariChoisi);
                  this.servicematch.getAllMatch().subscribe((match: Match[]) => {
                    this.match = match;
                    console.log(match)





                  });
                })
              }
            }
          }
        }
      }
        if (this.newmatch && this.newmatch.id) {
          this.servicematch.Updatmatch(this.newmatch).subscribe((newmatch: Match) => {
            console.log("match updated", newmatch);
            this.servicematch.getAllMatch().subscribe((match: Match[]) => {
              this.match = match;
              console.log(match)





            });
          })
        }
        else {
          this.servicematch.addMatch(this.newmatch).subscribe((newmatch: Match) => {
            console.log("match created", newmatch);

            console.log("mtc", this.newmatch);
            this.servicematch.getAllMatch().subscribe((match: Match[]) => {
              this.match = match;
              console.log(match)
            })
          });
        }



     

    })




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
    if (confirm("Vous etes sur?" + name)) {
      this.servicematch.onDeleteMatch(id).subscribe(data => {
        console.log(data);

        this.servicematch.getAllMatch().subscribe((match: Match[]) => {
          this.match = match;
          console.log(match)
        })
      })
    }
  }
  selectMatch(match: Match) {
    this.newmatch = match;
    console.log("sssss", this.newsport.id)
  }

  selectMatchDetails(match: Match) {
    this.newmatch = match;
    console.log("sssss", this.newsport.id)
  }


  onSportChange(event) {
    this.newmatch.pari_montant = event.target.value;
    console.log(event);
  }

}
