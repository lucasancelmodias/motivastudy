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

  httpOptions = {headers: new HttpHeaders(
    {'Content-Type': 'application/x-www-form-urlencoded'
    }
    )
  };

constructor(
  private http:HttpClient
  ) { }

  login(email:string, senha:string){
    const body = new HttpParams()
    .set('username', email)
    .set('password', senha);
    console.log(email)
    return this.http.post<any>(`${environment.url}/dologin`, body.toString(), this.httpOptions)
      .pipe(map(usuario => {
        console.log(usuario);

        return usuario;
      }))

  }

}
