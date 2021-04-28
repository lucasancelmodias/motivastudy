import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class CadastroService {

constructor(private http: HttpClient) { }


  cadastrarUsuario(form:any){
    this.http.post("http://localhost:8080/cadastro", form.value)
    .subscribe(
      (response:any) => {
      console.log('usuário cadastrado');
    },(error:any) => {
      console.error(error.error);
    }
    )
  }
}
