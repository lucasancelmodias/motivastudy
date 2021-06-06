import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class QuestaoService {

constructor(private http:HttpClient) { }

cadastrarQuestao(questao:any){
  return this.http.post<any>(`${environment.url}/questoes/salvar`, questao);
}

buscarQuestao(topicoId:number){
  return this.http.get<any>(`${environment.url}/questoes/topico/${topicoId}`)
}

}
