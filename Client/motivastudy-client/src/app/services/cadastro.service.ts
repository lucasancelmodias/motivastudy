import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { environment } from '../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class CadastroService {

constructor(private http: HttpClient) { }


  cadastrarUsuario(form:any){
    this.http.post(`${environment.url}/cadastro`, form.value)
    .subscribe(
      (response:any) => {
      console.log('usuário cadastrado');
    },(error:any) => {
      console.error(error.error);
    }
    )
  }
}
