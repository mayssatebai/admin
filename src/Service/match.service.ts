import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
 import { Match } from '../Model/match';
import { Sport } from '../Model/sport';

@Injectable({
  providedIn: 'root'
})
export class MatchService {

  
//   nouvMatch:any=new Match();
  nouvSport:any=new Sport();

  constructor(private http: HttpClient) { }

  getAllSport():Observable<any>{
    return this.http.get("http://localhost:8092/spring/api/sports");
  }
  // getAllSport() {
  //   return this.http.get<Sport[]>("http://localhost:8088/sports");
  // }
  getAllSportId(sport):Observable<any>{
    return this.http.get("http://localhost:8092/sport/"+sport.id);

  }

  public getsportid(id: number): Observable<Sport> {
  

    return this.http.get<Sport>("http://127.0.0.1:8092/spring/api/sport/"+id);

  }
  
  getAllSportId1(id):Observable<any>{
    return this.http.get("http://localhost:8092/sport/"+id);

  }
//   addSport(newSport:Sport){
//     const headers = { 'content-type': 'application/json'}  
//     const body=JSON.stringify(newSport);
//     return  this.http.post<any>'http://127.0.0.1:8092/spring/api/add-Sport',body,{'headers':headers}).subscribe(data => {
//      data.id;
     
//  });
// }
 creatSport(newSport:Sport): Observable<Sport>{
  return this.http.post<Sport>('http://localhost:8092/spring/api/add-Sport', newSport);
}

  

// public getpariid(id: number): Observable<Match> {
  

//   return this.http.get<Match>("http://127.0.0.1:8092/spring/api/pari/"+id);
  
// }

getAllMatch():Observable<any>{
  return this.http.get("http://localhost:8092/spring/api/paris");

}
// getAllMatch() {
//   return this.http.get<Match[]>("http://localhost:8088/paris");
// }
// public getmatch(id){
//   return this.http.get("http://127.0.0.1:8092/spring/api/pari/"+id);
// }

// addMatch(newMatch:Match){
//   const headers = { 'content-type': 'application/json'}  
//   const body=JSON.stringify(newMatch);
//   return  this.http.post<any>('http://localhost:8088/add-pari',body,{'headers':headers}).subscribe(data => {
//    data.id;
   
// });
// }

addMatch(newMatch:Match){
  return this.http.post<Match>('http://localhost:8092/spring/api/add-pari', newMatch);
}


public onDelete(id): Observable<any> {
  console.log(id);
  return this.http.delete<Sport>("http://localhost:8092/spring/api/supprim-sport/"+id);
  
}
public onDeleteMatch(id): Observable<any> {
  console.log(id);
  return this.http.delete<Match>("http://localhost:8092/spring/api/supprim-pari/"+id);
  
}
public Updatesportt(id: number): Observable<Sport> {
  
  return this.http.get<Sport>("http://localhost:8092/spring/api/sport/"+id);
}

public Updatesport(sport: Sport) {
    
  return this.http.post<Sport>('http://localhost:8092//spring/api/modif-sport', sport);
}
// public Updatematch(id: number): Observable<Match> {
  
//   return this.http.get<Match>("http://127.0.0.1:8092/spring/api/pari/"+id);
// }

public Updatmatch(match: Match): Observable<Match> {
    
  return this.http.post<Match>("http://localhost:8092/spring/api/modifpari", match);
}
}
