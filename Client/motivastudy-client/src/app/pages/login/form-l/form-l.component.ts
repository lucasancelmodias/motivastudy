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
    .pipe(first())
    .subscribe(data => {
      console.log(data)
    },
    error => {
      console.log(error)
    })
  }

}
