import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Parieur } from '../Model/parieur';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ParieurService {
  nouvParieur:any=new Parieur();

  constructor(private http: HttpClient) { }

  
  

  addParieur(newParieur:Parieur){

    return  this.http.post<any>('http:localhost:8092/spring/api/add-parieur',newParieur)
     

 
 
  }

  getAllParieur():Observable<any>{
    return this.http.get("http://localhost:8092/spring/api/parieurs");

  }
  public getparieur(par){
    return this.http.get("http://localhost:8092/spring/api/parieur/"+par.id);
  }
  public onDelete(id): Observable<any> {
    console.log(id);
    return this.http.delete<Parieur>("http://localhost:8092/spring/api/supprim-parieur/"+id);
    
  }
 
  public Updateparieur(id: number): Observable<Parieur> {
  
    return this.http.get<Parieur>("http://localhost:8092/spring/api/parieur/"+id);
  }
  public Updatepar2(parieur: Parieur): Observable<Parieur> {
    
    return this.http.post<Parieur>("http://localhost:8092/spring/api/modif-parieur", parieur);
  }
  
}