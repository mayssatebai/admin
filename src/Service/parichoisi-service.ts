import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PariChoisi } from '../Model/parichoisi';

@Injectable({
  providedIn: 'root'
})
export class PariChoisiService {

  nouvPariChoisi:any=new PariChoisi();
  

  constructor(private http: HttpClient) { }

  getAllPariChoisi():Observable<any>{
    return this.http.get("http://localhost:8092/spring/api/PariChoisi");
  }
  getAllPariChoisiId(equipe):Observable<any>{
    return this.http.get("http://localhost:8092/spring/api/PariChoisi/"+equipe.id);

  }
 
  addPariChoisi(newparichoisi:PariChoisi){
  
    return  this.http.post<PariChoisi>('http://localhost:8092/spring/api/add-PariChoisi',newparichoisi);
     

  
}
public onDelete(id): Observable<any> {
  console.log(id);
  return this.http.delete<PariChoisi>("http://localhost:8092/spring/api/supprim-parichoisi/"+id);
  
}
public UpdatePariChoisi(id: number): Observable<PariChoisi> {
  
  return this.http.get<PariChoisi>("http://localhost:8092/spring/api/parichoisi/"+id);
}

public UpdatePariChoisi2(parichoisi: PariChoisi): Observable<PariChoisi> {
    
  return this.http.post<PariChoisi>("http://localhost:8092/spring/api/modifPariChoisi", parichoisi);
}


}
