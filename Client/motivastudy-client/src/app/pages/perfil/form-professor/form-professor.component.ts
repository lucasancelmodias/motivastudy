import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CadastroService } from 'src/app/services/cadastro.service';
@Component({
  selector: 'app-form-professor',
  templateUrl: './form-professor.component.html',
  styleUrls: ['./form-professor.component.css']
})
export class FormProfessorComponent implements OnInit {

  constructor(private cadastroServ: CadastroService) { }

  ngOnInit(): void {
  }

  requisicaoProfessor(requisicaoForm: NgForm){
    
    console.log(requisicaoForm);

    this.cadastroServ.requisicaoProfessor(requisicaoForm);
  }

}
