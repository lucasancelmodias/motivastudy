import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-questoes',
  templateUrl: './questoes.component.html',
  styleUrls: ['./questoes.component.css']
})
export class QuestoesComponent implements OnInit {


  topicoIdAtual: number
  constructor() { }

  ngOnInit(): void {
  }

  topicoChange(event){
    console.log('evento no pai', event)
    this.topicoIdAtual = event;
  }
}
