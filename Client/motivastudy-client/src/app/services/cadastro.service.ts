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
    let error:string;
    let req = null;
    console.log('Form: ' + form.value.CheckProfessor);
    console.log('Form2: ' + !form.value.cfep);
    if(form.value.CheckProfessor && !form.value.cfep){
      error = 'Informe seu CFEP'
    } else if(form.value.CheckProfessor && form.value.checkOutro){
      error = 'Selecione somente uma opção'
    } else if (form.value.checkOutro && !form.value.descricaoContribuinte){
      error = 'Informe o motivo da Contribuição'
    } else if (form.value.CheckProfessor && form.value.cfep){
      req = {isProfessor: form.value.CheckProfessor, texto: form.value.cfep};
    } else if (form.value.checkOutro && form.value.descricaoContribuinte){
      req = {isProfessor: form.value.checkOutro, texto: form.value.descricaoContribuinte};
    }
    console.log('error: ' +error);
    if(error == null) {
      console.log('call')
      this.http.post(`${environment.url}/usuario/professor`, req)
      .subscribe(
        (response:any)=>{
          console.log(response);
        },
        (error:any)=>{
          console.log(error);
        }
      )
    }
    console.log('req', req);
  }
}
