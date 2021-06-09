import { Component, OnDestroy, OnInit, NgZone } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable, Subscription } from 'rxjs';
import { CadastroService } from 'src/app/services/cadastro.service';
import { AuthService } from 'src/app/services/auth.service';
@Component({
  selector: 'app-form-alterar-dados',
  templateUrl: './form-alterar-dados.component.html',
  styleUrls: ['./form-alterar-dados.component.css']
})
export class FormAlterarDadosComponent implements OnInit, OnDestroy {

  nome:string;
  email:string;
  private subscription: Subscription

  constructor(private cadastroServ: CadastroService,
              private authServ: AuthService) {  }

  ngOnInit(): void {
    this.getUser();
  }

  ngOnDestroy() {
    this.subscription.unsubscribe()
  }

  obj: any;

  getUser(){
    this.subscription = this.authServ.usuarioAtual
    .subscribe((usuario) => {
      this.nome = usuario.nome
      this.email = usuario.email
    })
  }

  updateData(requisicaoForm:NgForm){
    this.cadastroServ.updateUser(requisicaoForm)
    .subscribe(
      (response:any) =>{
        localStorage.setItem('usuario', JSON.stringify(response))
        this.authServ.usuarioAtualSubject.next(response)
        //alert("Dados Alterados com Sucesso!! Entre novamente para notar as alterações.");
        //window.location.reload();
      }
    )
  }

}
