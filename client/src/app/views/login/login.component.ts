import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../shared'
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css','../bootstrap.min.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  errorMessage: string = '';
  successMessage: string = '';

  constructor(public authService: AuthService, private router: Router,private fb: FormBuilder) {
    this.loginForm = this.fb.group({
      email: ['', Validators.required ],
      password: ['',Validators.required]
    });
   }

  ngOnInit(): void {
  }

  tryEmailLogin(value: { email: string; password: string; }){
    this.authService.LogInWithMail(value.email,value.password)
    .then(res => {
      console.log(res);
      this.errorMessage = "";
      this.successMessage = "You Logged in Successfully";
    }, err => {
      console.log(err);
      this.errorMessage = err.message;
      this.successMessage = "";
    })
  }


  tryLogOut(){
    this.authService.logOut()
    .then(res => {
      this.router.navigate(['/login']);
    })
  }
}
