import { Component, Input, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { QuestaoService } from 'src/app/services/questao.service';
import { Questao } from 'src/app/models/Questao';
@Component({
  selector: 'app-questao',
  templateUrl: './questao.component.html',
  styleUrls: ['./questao.component.css']
})
export class QuestaoComponent implements OnInit, OnChanges {

  @Input() topicoId: number
  questoes: Questao[]
  constructor(private quesService: QuestaoService) { }
  ngOnChanges(changes: SimpleChanges): void {
    console.log('changed',changes.topicoId.currentValue)
    if(!changes.topicoId.currentValue){
      return
    }
    this.quesService.buscarQuestao(changes.topicoId.currentValue)
      .subscribe((response) => {
        console.log('questao resp',response)
        this.questoes = response;
      })
  }

  ngOnInit(): void {
    console.log('componente questao')
    console.log(this.topicoId)
  }


}
