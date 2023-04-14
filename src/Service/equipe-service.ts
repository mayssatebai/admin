import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Equipe } from '../Model/equipe';

@Injectable({
  providedIn: 'root'
})
export class EquipeService {

  nouvEquipe:any=new Equipe();
  

  constructor(private http: HttpClient) { }

  getAllEquipe():Observable<any>{
    return this.http.get("http://localhost:8092/spring/api/equipe");
  }
  getAllEquipeId(equipe):Observable<any>{
    return this.http.get("http://localhost:8092/spring/api/equipe/"+equipe.id);

  }
 
  addEquipe(newEquipe:Equipe){
  
    return  this.http.post<Equipe>('http://localhost:8092/spring/api/add-equipe',newEquipe);
     

  
}
public onDelete(id): Observable<any> {
  console.log(id);
  return this.http.delete<Equipe>("http://localhost:8092/spring/api/supprim-equipe/"+id);
  
}
public Updateequipe(id: number): Observable<Equipe> {
  
  return this.http.get<Equipe>("http://localhost:8092/spring/api/equipe/"+id);
}

public Updateequipe2(equipe: Equipe): Observable<Equipe> {
    
  return this.http.post<Equipe>("http://localhost:8092/spring/api/modifEquipe", equipe);
}
}
