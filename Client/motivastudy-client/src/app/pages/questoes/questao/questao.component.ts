import { Component, Input, OnInit, OnChanges, SimpleChanges, OnDestroy } from '@angular/core';
import { QuestaoService } from 'src/app/services/questao.service';
import { Questao } from 'src/app/models/Questao';
import { Topico } from 'src/app/models/Topico';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-questao',
  templateUrl: './questao.component.html',
  styleUrls: ['./questao.component.css']
})
export class QuestaoComponent implements OnInit, OnChanges, OnDestroy {

  @Input() topico: Topico
  questoes: Questao[]
  dadosCarregados: boolean
  constructor(private quesService: QuestaoService) { }
  ngOnDestroy(): void {
    this.topico = null;
    this.questoes = null;
  }
  ngOnChanges(changes: SimpleChanges): void {
    console.log('changed',changes.topico.currentValue)
    if(!changes.topico.currentValue){
      return
    }
    this.quesService.buscarQuestao(changes.topico.currentValue.id)
      .subscribe((response) => {
        console.log('questao resp',response)
        this.questoes = response;
        this.dadosCarregados = true;
      })
  }

  ngOnInit(): void {
    console.log('componente questao')
    console.log(this.topico)
  }
  possuiQuestoes(): boolean{
    return this.questoes?.length > 0
  }

  responderQuestao(questaoForm:NgForm){
    console.log('respondendo questao')
    console.log(questaoForm)
    this.quesService.responderQuestao(questaoForm.form.value)
      .subscribe((response)=> {
        console.log(response)
        let questao = this.questoes.filter(ques => ques.id == response.questao)
        questao.forEach(ques => {
          ques.validacaoResposta = response.alternativaCorreta
          ques.alternativaRespondida = response.alternativaRespondida
          ques.respostaEstaCorreta = response.respostaEstaCorreta
        })
        console.log(questao)
      })
  }


}
