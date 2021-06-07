import { Component, OnInit } from '@angular/core';
import { Topico } from 'src/app/models/Topico';
@Component({
  selector: 'app-aulas',
  templateUrl: './aulas.component.html',
  styleUrls: ['./aulas.component.css']
})
export class AulasComponent implements OnInit {

  topicoAtual: Topico
  constructor() { }

  ngOnInit(): void {
  }

  topicoChange(event){
    console.log('evento no pai', event)
    this.topicoAtual = event;
  }

}
