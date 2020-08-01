import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AngularFireAuth } from '@angular/fire/auth';
import { take, switchMap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UnverifiedGuard implements CanActivate {

  constructor(private afAuth: AngularFireAuth, private router: Router) { }

  canActivate() {
    return this.afAuth.authState.pipe(
      take(1),
      switchMap(async (authState) => {
        if (authState) { 
          console.log(authState.emailVerified);
          if(!authState.emailVerified){
            this.router.navigate(['verify'])
          
            return false
          } else {
            return true
          }
        } else {
          this.router.navigate(['login'])
          return false
        }
      }),
    )
  }
}
  

