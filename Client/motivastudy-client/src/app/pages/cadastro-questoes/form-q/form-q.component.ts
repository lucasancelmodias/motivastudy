import { Component, OnInit } from '@angular/core';
import { DisciplinaService } from 'src/app/services/disciplina.service';
import { Disciplina } from 'src/app/models/Disciplina';
import { NgForm } from '@angular/forms';
import { Topico } from 'src/app/models/Topico';
import { QuestaoService } from 'src/app/services/questao.service';
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
  constructor(private dispService:DisciplinaService, private questService: QuestaoService) { }

  ngOnInit(): void {
    this.dispService.getDisciplinas().subscribe((response) => {

      this.disciplinas = response;
      console.log('respdisp',response)
      this.topicos = this.disciplinas[0]?.topicos;
    });
  }

  salvarQuestao(questaoForm:NgForm){
    console.log(questaoForm.form.value);

    this.questService.cadastrarQuestao(questaoForm.form.value).subscribe(resp => console.log(resp));
  }

  changeDisciplina(event:any){
    let currentDisp = this.disciplinas.filter(item => item.id == event.value);
    this.topicos = currentDisp[0]?.topicos;
  }

}
