import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CadastroService } from 'src/app/services/cadastro.service';

@Component({
  selector: 'app-form-alterar-dados',
  templateUrl: './form-alterar-dados.component.html',
  styleUrls: ['./form-alterar-dados.component.css']
})
export class FormAlterarDadosComponent implements OnInit {

  constructor(private cadastroServ: CadastroService) { }

  ngOnInit(): void {
  }

  updateData(requisicaoForm:NgForm){
    console.log('REQUISICAO DE UPDATE>>>> ' + requisicaoForm);
    this.cadastroServ.updateUser(requisicaoForm);
  }

}
