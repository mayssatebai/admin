import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Joueur } from '../Model/joueur';

@Injectable({
  providedIn: 'root'
})
export class JoueurService {

  nouvjoueur:any=new Joueur();
  

  constructor(private http: HttpClient) { }

  getAllJoueur():Observable<any>{
    return this.http.get("http://localhost:8092/spring/api/Joueur");
  }
  getAllJoueurId(joueur):Observable<any>{
    return this.http.get("http://localhost:8092/spring/api/joueur/"+joueur.id);

  }
  addJoueur(newJoueur:Joueur){
   
    return  this.http.post<any>('http://localhost:8092/spring/api/add-joueur',newJoueur);
   
     
 

  
}
public onDelete(id): Observable<any> {
  console.log(id);
  return this.http.delete<Joueur>("http://localhost:8092/spring/api/supprim-joueur/"+id);
  
}
public Updatejoueur(id: number): Observable<Joueur> {
  
  return this.http.get<Joueur>("http://localhost:8092/spring/api/joueur/"+id);
}

public Updatejoueur2(joueur: Joueur): Observable<Joueur> {
    
  return this.http.post<Joueur>("http://localhost:8092/spring/api/modif-joueur", joueur);
}
}
