import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { ResetAccountComponent } from './auth/reset-account/reset-account.component';
import { CompleteRegisterComponent } from './shared/page/complete-register/complete-register.component';
import { HomeComponent } from './shared/page/home/home.component';
import {ModalComponent} from './shared/page/modals/modal/modal.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },

  { path: 'register', component: RegisterComponent },

  { path: 'home', component: HomeComponent },

  { path: 'restAccount', component: ResetAccountComponent },

  {path: 'complete-registration', component: CompleteRegisterComponent},

  {path: 'modal', component: ModalComponent},

  { path: '**', pathMatch: 'full', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
