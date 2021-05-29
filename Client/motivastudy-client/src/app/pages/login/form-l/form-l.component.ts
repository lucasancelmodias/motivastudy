import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AuthService } from '../../../services/auth.service';
@Component({
  selector: 'app-form-l',
  templateUrl: './form-l.component.html',
  styleUrls: ['./form-l.component.css']
})
export class FormLComponent implements OnInit {

  constructor(private auth:AuthService) { }

  ngOnInit(): void {
  }
  onSubmit(loginForm:NgForm){
    console.log(loginForm.value);
    this.auth.login(loginForm.value.username,loginForm.value.password)
    .subscribe(
      (response:any) => {
      console.log('response', response)
      //Direciona page login
      window.location.href = '/questoes';
    },(error: HttpErrorResponse) => {
      console.log('error Message',error.error.mensagem)
      alert(error.error.mensagem);
    })
  }

}
