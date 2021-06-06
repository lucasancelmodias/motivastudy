import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { DisciplinaService } from '../../../services/disciplina.service';
import { Disciplina } from 'src/app/models/Disciplina';
import { Topico } from 'src/app/models/Topico';
@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  disciplinas: Disciplina[]
  @Output() topico: EventEmitter<Topico> = new EventEmitter<Topico>();
  constructor(private dispService:DisciplinaService){}

  ngOnInit(){
    this.dispService.getDisciplinas()
      .subscribe((response) => {
        console.log({response})
        this.disciplinas = response;
      })
  }

  alterarTopico(event,topico:Topico){
    event.stopPropagation()
    event.preventDefault()


    console.log('alterando topico', topico)
    this.topico.emit(topico);
  }
}
