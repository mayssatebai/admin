import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegistreComponent } from './registre/registre.component';
const routes: Routes =[
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },{path:'login',component: LoginAdminComponent}

,{
  path: '',
  redirectTo: 'registre',
  pathMatch: 'full',
},{path:'registre',component: RegistreComponent},
 {
    path: '',
    component: AdminLayoutComponent,
    children: [
        {
      path: '',
      loadChildren: () => import('./layouts/admin-layout/admin-layout.module').then(x=>x.AdminLayoutModule)
  }]},
  {
    path: '**',
    redirectTo: 'equipe'
  }
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
  ],
})
export class AppRoutingModule { }
