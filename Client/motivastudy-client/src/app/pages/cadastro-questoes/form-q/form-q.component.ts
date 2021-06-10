import { Component, OnInit } from '@angular/core';
import { DisciplinaService } from 'src/app/services/disciplina.service';
import { Disciplina } from 'src/app/models/Disciplina';
import { NgForm } from '@angular/forms';
import { Topico } from 'src/app/models/Topico';
import { QuestaoService } from 'src/app/services/questao.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-form-q',
  templateUrl: './form-q.component.html',
  styleUrls: ['./form-q.component.css']
})
export class FormQComponent implements OnInit {

  disciplinas:Disciplina[]
  topicos: Topico[]
  disciplinaId: string
  topicoId: string
  constructor(private dispService:DisciplinaService, 
              private questService: QuestaoService,
              private route:Router) { }

  ngOnInit(): void {
    this.dispService.getDisciplinas().subscribe((response) => {

      this.disciplinas = response;
      console.log('respdisp',response)
      this.topicos = this.disciplinas[0]?.topicos;
    });
  }

  salvarQuestao(questaoForm:NgForm){
    console.log(questaoForm.form.value);

    this.questService.cadastrarQuestao(questaoForm.form.value)
    .subscribe(
      (response:any) => {
        let message = 'Questão criada com sucesso'; 
        alert(message);
        this.route.navigate(['videos']);
      },(error: HttpErrorResponse) => {
        let message = 'Houve um erro ao cadastrar a questão, favor contatar um Administrador';
        alert(message);
      }
      );
  }

  changeDisciplina(event:any){
    let currentDisp = this.disciplinas.filter(item => item.id == event.value);
    this.topicos = currentDisp[0]?.topicos;
  }

}
