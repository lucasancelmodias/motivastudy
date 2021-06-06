import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { DisciplinaService } from '../../../services/disciplina.service';
import { Disciplina } from 'src/app/models/Disciplina';
@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  disciplinas: Disciplina[]
  @Output() topico: EventEmitter<number> = new EventEmitter<number>();
  constructor(private dispService:DisciplinaService){}

  ngOnInit(){
    this.dispService.getDisciplinas()
      .subscribe((response) => {
        console.log({response})
        this.disciplinas = response;
      })
  }

  alterarTopico(event){
    event.stopPropagation()
    event.preventDefault()
    //console.log(event.target.dataset.sectionvalue)
    let topicoId = event.target.dataset.sectionvalue;
    //console.log('alterando topico')
    this.topico.emit(topicoId);
  }
}
