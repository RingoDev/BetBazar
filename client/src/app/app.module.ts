import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AngularFireModule } from '@angular/fire';
import { AngularFirestoreModule } from '@angular/fire/firestore';
import { AngularFireAuthModule } from '@angular/fire/auth';
import { environment } from '../environments/environment';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {
  OpenBetsComponent,
  LoginComponent,
  RegisterComponent,
  LandingComponent,
  VerifyComponent,
  PageNotFoundComponent,
  TournamentComponent,
  NavbarComponent,
  AcceptedBetsComponent,
  ActiveBetsComponent
} from './views/index';



@NgModule({
  declarations: [
    AppComponent,
    TournamentComponent,
    LoginComponent,
    RegisterComponent,
    LandingComponent,
    PageNotFoundComponent,
    NavbarComponent,
    VerifyComponent,
    OpenBetsComponent,
    AcceptedBetsComponent,
    ActiveBetsComponent],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFirestoreModule, // imports firebase/firestore, only needed for database features
    AngularFireAuthModule, // imports firebase/auth, only needed for auth features
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
