import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { first, map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class CadastroService {

constructor(private http: HttpClient) { }


  cadastrarUsuario(form:any){
    console.log('Pegando informações do Form');
    console.log(form.value);
    this.http.post("http://localhost:8080/cadastro", form.value)
    .subscribe((result:any) => {
      console.log('Resposta');
      console.log(result);
    })
  }
}
