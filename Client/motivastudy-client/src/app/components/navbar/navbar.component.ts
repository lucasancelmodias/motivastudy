import { Component, OnInit } from '@angular/core';
import { CadastroService } from 'src/app/services/cadastro.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  
  nome:string
  perfil: string;
  
  constructor(private cadastroServ: CadastroService) {  }

  ngOnInit(): void {
    this.getUser();
  }

  getUser(){
    this.cadastroServ.getUser()
    .subscribe(
      (response:any)=>{
        this.nome = response.nome;
        for(var i=0; i< response.perfis.length;i++){
          if(response.perfis[i].nome == 'ALUNO'){
            this.perfil = response.perfis[i].nome;
            console.log('this.perfil: ' +this.perfil);
          }
        }
      }
    );
  }
}
