import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Disciplina } from '../models/Disciplina';
import { Observable } from 'rxjs';
import { map, take } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class DisciplinaService {

constructor(private http:HttpClient) { }

getDisciplinas() : Observable<Disciplina[]>{
  return this.http.get<Disciplina[]>(`${environment.url}/disciplinas`)
  .pipe(map((response:any) => <Disciplina[]>response),take(1))

}
}



