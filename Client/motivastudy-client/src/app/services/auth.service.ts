import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';
import { HttpParams } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public usuarioAtualSubject: BehaviorSubject<any>;
  public usuarioAtual: Observable<any>
  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'}),
    observe:'response' as 'response'
  };

constructor(private http:HttpClient) {
  this.usuarioAtualSubject = new BehaviorSubject<any>(JSON.parse(localStorage.getItem('usuario')))
  this.usuarioAtual = this.usuarioAtualSubject.asObservable();

}

  login(email:string, senha:string){
    const body = new HttpParams()
    .set('username', email)
    .set('password', senha);
    return this.http.post<any>(`${environment.url}/dologin`, body.toString(), this.httpOptions)
    .pipe(map(response => {
      localStorage.setItem('usuario',JSON.stringify(response.body))
      this.usuarioAtualSubject.next(response.body)
      return response
    }))
  }

  logout(){
    return this.http.post<any>(`${environment.url}/logout`, {})
      .pipe(map(res => {
      this.usuarioAtualSubject.next(null)
      return res
      }))
  }

  usuarioAtualValue() {
    return this.usuarioAtualSubject.value;
  }

  isLogged(){
    return this.usuarioAtual
      .pipe(map(user =>{
        if(user){
          return true
        }else {
          return false
        }
      }))
  }

}
