import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Disciplina } from 'src/app/models/Disciplina';
import { CadastroService } from 'src/app/services/cadastro.service';

@Component({
  selector: 'app-form-professor',
  templateUrl: './form-professor.component.html',
  styleUrls: ['./form-professor.component.css']
})
export class FormProfessorComponent implements OnInit {
  disp:Disciplina[]
  constructor(private cadastroServ: CadastroService) { }

  ngOnInit(){
    
  }

  requisicaoProfessor(requisicaoForm: NgForm){

    console.log(requisicaoForm);

    this.cadastroServ.requisicaoProfessor(requisicaoForm);
  }

}
