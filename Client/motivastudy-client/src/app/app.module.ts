import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';
import { LoginComponent } from './pages/login/login.component';
import { FormComponent } from './pages/cadastro/form/form.component';
import { FormLComponent } from './pages/login/form-l/form-l.component';
import { CadastroQuestoesComponent } from './pages/cadastro-questoes/cadastro-questoes.component';
import { FormQComponent } from './pages/cadastro-questoes/form-q/form-q.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CadastroComponent,
    LoginComponent,
    FormComponent,
    FormLComponent,
    CadastroQuestoesComponent,
    FormQComponent,
    NavbarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
