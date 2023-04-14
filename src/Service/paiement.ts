import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Paiment } from '../Model/paiment';

@Injectable({
  providedIn: 'root'
})
export class PaiementService {

  nouvPaiement:any=new Paiment();
  

  constructor(private http: HttpClient) { }

  getAllPaiement():Observable<any>{
    return this.http.get("http://localhost:8092/spring/api/interventions");
  }
  getAllPaiementId(paiement):Observable<any>{
    return this.http.get("http://localhost:8092/spring/api/intervention/"+paiement.id);

  }
  addPaiment(newPaiement:Paiment){

    return  this.http.post<any>('http://localhost:8092/spring/api/add-inter',newPaiement)
 
  
}
public onDelete(id): Observable<any> {
  console.log(id);
  return this.http.delete<Paiment>("http://localhost:8092/spring/api/supprim-inter/"+id);
  
}
public Updatepaiement(id: number): Observable<Paiment> {
  
  return this.http.get<Paiment>("http://localhost:8092/spring/api/intervention/"+id);
}

public Updatepaiement2(paiement: Paiment): Observable<Paiment> {
    
  return this.http.post<Paiment>("http://localhost:8092/spring/api/modif-inter", paiement);
}


}
