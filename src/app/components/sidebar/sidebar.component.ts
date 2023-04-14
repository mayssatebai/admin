import { Component, OnInit } from '@angular/core';

declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
  { path: '/sport', title: 'Sports',  icon:'sport_user-run', class: '' },
  { path: '/match', title: 'Match',  icon:'sport_trophy', class: '' },
    { path: '/equipe', title: 'Equipe',  icon: 'design_vector', class: '' },
    { path: '/joueur', title: 'Joueur',  icon:'users_single-02', class: '' },
  
    { path: '/parieur', title: 'Parieurs',  icon:'business_badge', class: '' },

    { path: '/pari', title: 'Paiement',  icon:'business_money-coins', class: '' },
   
  
   

];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ( window.innerWidth > 991) {
          return false;
      }
      return true;
  };
}
