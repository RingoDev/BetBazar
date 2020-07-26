import { Component, OnInit } from '@angular/core';

import { AngularFireAuth } from '@angular/fire/auth'

import { AuthService } from '../shared/services/auth.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css', '../bootstrap.min.css']
})
export class NavbarComponent implements OnInit {



  constructor(public afAuth: AngularFireAuth, public authService: AuthService, private router: Router) { }

  ngOnInit(): void {

  }

  checkLogin() {
    return this.authService.isLoggedIn;
  }

  tryLogOut() {
    this.authService.logOut()
      .then(res => {
        this.router.navigate(['/login']);
      })
  }
}
