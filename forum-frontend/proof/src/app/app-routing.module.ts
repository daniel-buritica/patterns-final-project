import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {CompleteRegisterComponent} from '../app/vistas/complete-register/complete-register.component'

const routes: Routes = [
  {path:'', redirectTo:'app-complete-register', pathMatch:'full'},
  {path:'app-complete-register', component:CompleteRegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
