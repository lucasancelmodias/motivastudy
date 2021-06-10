import { Component, OnInit } from '@angular/core';
import { NgForm, FormControl, Validators } from '@angular/forms';
import { CadastroService } from 'src/app/services/cadastro.service';
@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor(private cadastroServ: CadastroService) { }

  ngOnInit(): void {
  }

  cadastrar(cadastroForm:NgForm){
    this.cadastroServ.cadastrarUsuario(cadastroForm);
  }

}
