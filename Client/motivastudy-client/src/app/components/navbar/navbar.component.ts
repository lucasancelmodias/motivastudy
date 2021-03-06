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
  usuario:any

  constructor(private cadastroServ: CadastroService, private authService: AuthService, private route: Router) {  }

  ngOnInit(): void {
    this.getUser();
    this.authService.usuarioAtual.subscribe((resp)=> {
      this.usuario = resp
    })

  }

  getUser(){
    this.authService.usuarioAtual
      .subscribe((usuario)=>{
        this.nome = usuario.nome
        //var perfilArr = usuario.perfis.filter(perfil => perfil.nome == "ADMIN" || perfil.nome == 'PROFESSOR')
        for(let i=0; i<usuario.perfis.length;i++){
          if(usuario.perfis[i].nome == "ADMIN" || usuario.perfis[i].nome == 'PROFESSOR' ){
            this.perfil = usuario.perfis[i].nome;
          } else {
            this.perfil = 'ALUNO';
          }
        }
        //this.perfil = perfilArr?.[0]
      })
  }

  logout(){
    localStorage.removeItem('usuario')
    this.authService.logout().subscribe((resp)=>{

      this.route.navigate(['/'])
    })
  }
}
