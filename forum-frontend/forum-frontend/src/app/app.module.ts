import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { AngularFireModule } from '@angular/fire/compat';

import { AngularFireAuthModule } from '@angular/fire/compat/auth';

import { AngularFireStorageModule } from '@angular/fire/compat/storage';

import { AngularFirestoreModule } from '@angular/fire/compat/firestore';

import { AngularFireDatabaseModule } from '@angular/fire/compat/database';

import {HttpClientModule} from '@angular/common/http';

import { environment } from '../environments/environment';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { ResetAccountComponent } from './auth/reset-account/reset-account.component';
import { HomeComponent } from './shared/page/home/home.component';
import { HeaderComponent } from './shared/page/header/header.component';
import { CompleteRegisterComponent } from './shared/page/complete-register/complete-register.component';
import {ReactiveFormsModule} from '@angular/forms';
import { ModalComponent } from './shared/page/modals/modal/modal.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ResetAccountComponent,
    HomeComponent,
    HeaderComponent,
    CompleteRegisterComponent,
    ModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularFireAuthModule,
    AngularFirestoreModule,
    AngularFireStorageModule,
    AngularFireDatabaseModule,
    AngularFireModule.initializeApp(environment.firebase),
    HttpClientModule,    
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
