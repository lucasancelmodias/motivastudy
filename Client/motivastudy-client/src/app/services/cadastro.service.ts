import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpResponse} from '@angular/common/http';
import { environment } from '../../environments/environment';
import { map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class CadastroService {

constructor(private http: HttpClient) { }



  cadastrarUsuario(form:any){
    console.log('FORM >>> ' +form);
    this.http.post(`${environment.url}/cadastro`, form.value)
    .subscribe(
      (response:any) => {
        alert(response.message); //Response com message do back
        //Direciona page login
        window.location.href = '/login';
    },(error: HttpErrorResponse) => {
      console.error(error.error);
      alert(error.error.message);
    }
    )
  }

  requisicaoProfessor(form:any){
    let req = {isProfessor: form.value.CheckProfessor, texto: form.value.descricaoContribuinte};
    this.http.post(`${environment.url}/usuario/professor`, req)
    .subscribe(
      (response:any)=>{
        console.log(response);
      },
      (error:any)=>{
        console.log(error);
      }
    )
    console.log('req', req);
  }
}
