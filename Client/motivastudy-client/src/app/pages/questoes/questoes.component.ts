import { Component, OnInit } from '@angular/core';
import { Topico } from 'src/app/models/Topico';
@Component({
  selector: 'app-questoes',
  templateUrl: './questoes.component.html',
  styleUrls: ['./questoes.component.css']
})
export class QuestoesComponent implements OnInit {


  topicoAtual: Topico
  constructor() { }

  ngOnInit(): void {
  }

  topicoChange(event){
    console.log('evento no pai', event)
    this.topicoAtual = event;
  }
}
