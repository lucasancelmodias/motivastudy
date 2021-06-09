import { NgModule } from '@angular/core';
import { BrowserModule} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent, SafePipe } from './app.component';
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
import { AulasComponent } from './pages/aulas/aulas.component';
import { SidebarAulasComponent } from './pages/aulas/sidebar-aulas/sidebar-aulas.component';
import { VideoAulaComponent } from './pages/aulas/video-aula/video-aula.component';
import { HomeAulasComponent } from './pages/aulas/home-aulas/home-aulas.component';
import { NgxSpinnerModule } from 'ngx-spinner';
import { CommonModule } from '@angular/common';
import { VideosComponent } from './pages/videos/videos.component';
import { ApostilaComponent } from './pages/apostila/apostila.component';
import { CronogramaComponent } from './pages/apostila/cronograma/cronograma.component';
import { MetodosEstudoComponent } from './pages/apostila/metodos-estudo/metodos-estudo.component';
import { CenterTextComponent } from './pages/apostila/center-text/center-text.component';
import { CenterText2Component } from './pages/apostila/center-text2/center-text2.component';
import { EnemComponent } from './pages/enem/enem.component';
import { SisuComponent } from './pages/sisu/sisu.component';
import { NavSuperiorComponent } from './pages/home/nav-superior/nav-superior.component';
import { TituloProgressoComponent } from './pages/questoes/progresso/titulo-progresso/titulo-progresso.component';
import { TituloHomeComponent } from './pages/aulas/home-aulas/titulo-home/titulo-home.component';

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
    ProgressoComponent,
    AulasComponent,
    SidebarAulasComponent,
    VideoAulaComponent,
    HomeAulasComponent,
    VideosComponent,
    SafePipe,
    ApostilaComponent,
    CronogramaComponent,
    MetodosEstudoComponent,
    CenterTextComponent,
    CenterText2Component,
    EnemComponent,
    SisuComponent,
    NavSuperiorComponent,
    TituloProgressoComponent,
    TituloHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxSpinnerModule,
    CommonModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: HttpRequestInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
