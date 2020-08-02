import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {
  AngularFireAuthGuard,
  redirectUnauthorizedTo,
  redirectLoggedInTo,
} from '@angular/fire/auth-guard';
import {
  OpenBetsComponent,
  LoginComponent,
  RegisterComponent,
  LandingComponent,
  VerifyComponent,
  PageNotFoundComponent,
  TournamentComponent,
  AcceptedBetsComponent,
  ActiveBetsComponent
} from './views/index';
import { UnverifiedGuard } from "./guard/unverified.guard";
import { VerifiedGuard } from './guard/verified.guard';



// UnverifiedGuard: redirects not logged in to login and unverified to verify

const redirectUnauthorizedToLogin = () => redirectUnauthorizedTo(['login']);
const redirectLoggedInToUserspace = () => redirectLoggedInTo(['tournament']);

const routes: Routes = [
  { path: '', component: LandingComponent },

  {
    path: 'activebets', component: ActiveBetsComponent,
    canActivate: [UnverifiedGuard]
  },
  {
    path: 'acceptedbets', component: AcceptedBetsComponent,
    canActivate: [UnverifiedGuard]
  },
  {
    path: 'openbets', component: OpenBetsComponent,
    canActivate: [UnverifiedGuard]
  },
  {
    path: 'tournament', component: TournamentComponent,
    canActivate: [UnverifiedGuard],
  },
  {
    path: 'verify', component: VerifyComponent,
    canActivate: [VerifiedGuard],
  },
  {
    path: 'login', component: LoginComponent,
    canActivate: [AngularFireAuthGuard],
    data: {
      authGuardPipe: redirectLoggedInToUserspace
    }
  },
  {
    path: 'register', component: RegisterComponent,
    canActivate: [AngularFireAuthGuard],
    data: {
      authGuardPipe: redirectLoggedInToUserspace
    }
  },
  { path: '**', component: PageNotFoundComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
