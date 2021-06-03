import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpResponse} from '@angular/common/http';
import { environment } from '../../environments/environment';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class CadastroService {

constructor(
  private http: HttpClient,
  private route:Router) { }

  cadastrarUsuario(form:any){
    console.log('FORM >>> ' +form);
    this.http.post(`${environment.url}/cadastro`, form.value)
    .subscribe(
      (response:any) => {
        alert(response.message); //Response com message do back
        //Direciona page login
        this.route.navigate(['login']);
    },(error: HttpErrorResponse) => {
      console.error(error.error);
      alert(error.error.message);
    }
    )
  }

  requisicaoProfessor(form:any){
    let error = null;
    let req = null;
    if(!form.value.CheckProfessor && !form.value.cfep && 
      !form.value.checkOutro && !form.value.descricaoContribuinte){
        error = 'Nenhum dado Informado';
    }
    else if(form.value.CheckProfessor && !form.value.cfep){
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
    if(error == null && req != null) {
      this.http.post(`${environment.url}/usuario/professor`, req)
      .subscribe(
        (response:any)=>{
          console.log(response);
          alert('Solicitação feita com sucesso. Aguarde entrarmos em contato');
          window.location.reload();
        },
        (error:any)=>{
          console.log(error);
        }
      )
    } else alert(error);
  }
}
