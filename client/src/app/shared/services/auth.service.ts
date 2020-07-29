import { Injectable } from '@angular/core';
import * as firebase from 'firebase/app';
import { AngularFireAuth } from '@angular/fire/auth'
import { HttpClient } from '@angular/common/http';
import { User } from '../../model/user'
import { Router } from "@angular/router";



@Injectable({
  providedIn: 'root'
})
export class AuthService {

  userData: any; // Save logged in user data
  constructor(private http: HttpClient,
    public router: Router,
    public afAuth: AngularFireAuth) {

    /* Saving user data in localstorage when 
logged in and setting up null when logged out */
    this.afAuth.authState.subscribe(user => {
      if (user) {
        this.userData = user;
        localStorage.setItem('user', JSON.stringify(this.userData));
        JSON.parse(localStorage.getItem('user'));
      } else {
        localStorage.setItem('user', null);
        JSON.parse(localStorage.getItem('user'));
      }
    })
  }

  // Sign up with email/password
  async signUpWithMail(email, password) {
    return this.afAuth.createUserWithEmailAndPassword(email, password)
      .then((result) => {
        /* Call the SendVerificaitonMail() function when new user sign 
        up and returns promise */
        this.SendVerificationMail();
        this.SetUserData(result.user);
      }).catch((error) => {
        window.alert(error.message)
      })
  }

  // Send email verfification when new user sign up
  async SendVerificationMail() {
    return this.afAuth.currentUser.then((user) => {
      user.sendEmailVerification()
    })
      .then(() => {
        this.router.navigate(['verify']);
      })
  }

  /* Setting up user data when sign in with username/password, 
sign up with username/password and sign in with social auth  
provider in Backend DB*/
  SetUserData(user) {
    const userData: User = {
      uid: user.uid,
      email: user.email,
      displayName: user.displayName,
      photoURL: user.photoURL,
      emailVerified: user.emailVerified
    }
  }


  get isLoggedIn(): boolean {
    const user = JSON.parse(localStorage.getItem('user'));
    return (user !== null);
  }

  loginWithGoogle() {
    return new Promise<any>((resolve, reject) => {
      let provider = new firebase.auth.GoogleAuthProvider();
      provider.addScope('profile');
      provider.addScope('email');
      this.afAuth.signInWithPopup(provider)
        .then(res => {
          resolve(res);
        }, err => {
          console.log(err);
          reject(err);
        })
    })

  }

  logOut() {
    return firebase.auth().signOut();
  }
}


