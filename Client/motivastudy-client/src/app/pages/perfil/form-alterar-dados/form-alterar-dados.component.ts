import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';
import { CadastroService } from 'src/app/services/cadastro.service';

@Component({
  selector: 'app-form-alterar-dados',
  templateUrl: './form-alterar-dados.component.html',
  styleUrls: ['./form-alterar-dados.component.css']
})
export class FormAlterarDadosComponent implements OnInit, OnDestroy {

  nome:string;
  email:string;
  private subscription: Subscription

  constructor(private cadastroServ: CadastroService) {  }

  ngOnInit(): void {
    this.subscription = this.cadastroServ.getUser()
    .subscribe(
      (response:any)=>{
        this.nome = response.nome;
        this.email = response.email;
      }
    );
  }

  ngOnDestroy() {
    this.subscription.unsubscribe()
  }

  updateData(requisicaoForm:NgForm){
    this.cadastroServ.updateUser(requisicaoForm)
    .subscribe(
      (response:any) =>{
        alert("Dados Alterados com Sucesso!! Entre novamente para notar as alterações.");
        window.location.reload();
      }
    )
  }

}
