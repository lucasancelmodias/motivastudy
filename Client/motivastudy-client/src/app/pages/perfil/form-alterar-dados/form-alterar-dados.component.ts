import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpResponse} from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { CadastroService } from 'src/app/services/cadastro.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-form-alterar-dados',
  templateUrl: './form-alterar-dados.component.html',
  styleUrls: ['./form-alterar-dados.component.css']
})
export class FormAlterarDadosComponent implements OnInit {

  nome:string;
  email:string;

  constructor(private cadastroServ: CadastroService, 
              private http: HttpClient) {  }

  ngOnInit(): void {
    this.getUser();
  }

  getUser() : void{
    this.http.get(`${environment.url}/user`)
    .subscribe(
      (response:any)=>{
        this.nome = response.nome;
        this.email = response.email;
      }
    )
  }
  updateData(requisicaoForm:NgForm){
    this.cadastroServ.updateUser(requisicaoForm);
  }

}
