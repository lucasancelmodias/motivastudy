import { Injectable } from "@angular/core";
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    //req = req.clone({withCredentials: true});
    // if(req.url.includes('/dologin')){
    //   console.log('skip login', req);
    //   return next.handle(req);
    // }

    req = req.clone({withCredentials: true});
    console.log('outras requisições', req);
    console.log('headers', req.headers.keys())
    return next.handle(req);
  }
}
