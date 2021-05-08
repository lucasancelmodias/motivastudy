import { Injectable } from "@angular/core";
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    //req = req.clone({withCredentials: true});
    if(req.url.includes('/dologin')){
      console.log('skip login', req);
      return next.handle(req);
    }
    console.log('outras requisições', req);
    req = req.clone({withCredentials: true});

    return next.handle(req);
  }
}
