import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CadastroService } from 'src/app/services/cadastro.service';

@Component({
  selector: 'app-form-alterar-dados',
  templateUrl: './form-alterar-dados.component.html',
  styleUrls: ['./form-alterar-dados.component.css']
})
export class FormAlterarDadosComponent implements OnInit {

  nome:string;
  email:string;

  constructor(private cadastroServ: CadastroService) {  }

  ngOnInit(): void {
    this.cadastroServ.getUser()
    .subscribe(
      (response:any)=>{
        this.nome = response.nome;
        this.email = response.email;
      }
    )
  }

  updateData(requisicaoForm:NgForm){
    this.cadastroServ.updateUser(requisicaoForm);
    console.log('requisicaoForm.value.nome: ' +requisicaoForm.value.nome);
    this.nome = requisicaoForm.value.nome;
  }

}
