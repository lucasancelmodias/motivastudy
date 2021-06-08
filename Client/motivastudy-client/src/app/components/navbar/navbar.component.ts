import { Component, OnInit } from '@angular/core';
import { CadastroService } from 'src/app/services/cadastro.service';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  nome:string
  perfil: string;

  constructor(private cadastroServ: CadastroService, private authService: AuthService, private route: Router) {  }

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

  logout(){
    this.authService.logout().subscribe((resp)=>{
      console.log(resp);
      this.route.navigate(['/'])
    })
  }
}
