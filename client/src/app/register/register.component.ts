import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/services/auth/auth.service';
import { Router } from '@angular/router';
import { FormGroup,Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css',"../bootstrap.min.css" ]
})
export class RegisterComponent {

  registerForm: FormGroup;
  errorMessage: string = '';
  successMessage: string = '';

  constructor(
    public authService: AuthService,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.createForm();
   }

   createForm() {
     this.registerForm = this.fb.group({
       email: ['', Validators.required ],
       password: ['',Validators.required]
     });
   }


   tryRegister(value: { email: string; password: string; }){
     this.authService.signUpWithMail(value.email,value.password)
     .then(res => {
       console.log(res);
       this.errorMessage = "";
       this.successMessage = "Your account has been created";
     }, err => {
       console.log(err);
       this.errorMessage = err.message;
       this.successMessage = "";
     })
   }

  tryGoogleLogin() {
    this.authService.loginWithGoogle()
      .then(res => {
        this.router.navigate(['/tournament']);
      })
  }

}
