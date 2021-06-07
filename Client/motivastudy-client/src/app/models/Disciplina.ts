import { Topico } from "./Topico";

export class Disciplina {
  id:string;
  nome:string;
  topicos:Topico[]
  constructor(id:string, nome:string, topicos:Topico[]){
    this.id = id;
    this.nome = nome;
    this.topicos = topicos;
  }
}
