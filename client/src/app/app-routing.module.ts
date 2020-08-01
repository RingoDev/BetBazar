import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LandingComponent } from './landing/landing.component';
import { TournamentComponent } from './tournament/tournament.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AngularFireAuthGuard, redirectUnauthorizedTo, redirectLoggedInTo, emailVerified } from '@angular/fire/auth-guard';
import { VerifyComponent } from './verify/verify.component';
import { map } from 'rxjs/operators';
import { User } from './model/user';
import { UnverifiedGuard } from "./guard/unverified.guard";
import { VerifiedGuard } from './guard/verified.guard';
import { OpenBetsComponent } from './userSpace/open-bets/open-bets.component'


// UnverifiedGuard: redirects not logged in to login and unverified to verify

const redirectUnauthorizedToLogin = () => redirectUnauthorizedTo(['login']);
const redirectLoggedInToUserspace = () => redirectLoggedInTo(['tournament']);

const routes: Routes = [
  { path: '', component: LandingComponent },

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
