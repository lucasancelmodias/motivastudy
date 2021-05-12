import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { CadastroComponent } from './pages/cadastro/cadastro.component';
import { LoginComponent } from './pages/login/login.component';
import { FormComponent } from './pages/cadastro/form/form.component';
import { FormLComponent } from './pages/login/form-l/form-l.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpRequestInterceptor } from './services/HttpRequestInterceptor';
import { CadastroQuestoesComponent } from './pages/cadastro-questoes/cadastro-questoes.component';
import { FormQComponent } from './pages/cadastro-questoes/form-q/form-q.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { QuestoesComponent } from './pages/questoes/questoes.component';
import { SidebarComponent } from './pages/questoes/sidebar/sidebar.component';
import { QuestaoComponent } from './pages/questoes/questao/questao.component';
import { PerfilComponent } from './pages/perfil/perfil.component';
import { FormAlterarDadosComponent } from './pages/perfil/form-alterar-dados/form-alterar-dados.component';
import { FormProfessorComponent } from './pages/perfil/form-professor/form-professor.component';
import { ProgressoComponent } from './pages/questoes/progresso/progresso.component';

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
    FooterComponent,
    QuestoesComponent,
    SidebarComponent,
    QuestaoComponent,
    PerfilComponent,
    FormAlterarDadosComponent,
    FormProfessorComponent,
    ProgressoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: HttpRequestInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
