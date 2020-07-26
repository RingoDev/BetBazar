import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/services/auth.service'
import { Router, Params } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css',"../bootstrap.min.css"]
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(public authService: AuthService, private router: Router,private fb: FormBuilder) {
    this.loginForm = this.fb.group({
      email: ['', Validators.required ],
      password: ['',Validators.required]
    });
   }

  ngOnInit(): void {
  }


  tryLogOut(){
    this.authService.logOut()
    .then(res => {
      this.router.navigate(['/login']);
    })
  }

  tryGoogleLogin() {
    this.authService.loginWithGoogle()
      .then(res => {
        this.router.navigate(['/tournament']);
      })
  }
}
