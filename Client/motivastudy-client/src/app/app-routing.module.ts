import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Importação dos componentes das páginas
import { HomeComponent } from "./pages/home/home.component";
import { CadastroComponent } from "./pages/cadastro/cadastro.component";
import { LoginComponent } from "./pages/login/login.component";
import { CadastroQuestoesComponent } from "./pages/cadastro-questoes/cadastro-questoes.component"
import { QuestoesComponent} from "./pages/questoes/questoes.component"
import { PerfilComponent } from "./pages/perfil/perfil.component"
import { VideosComponent } from './pages/videos/videos.component';
import { AulasComponent } from './pages/aulas/aulas.component';
import {ApostilaComponent} from './pages/apostila/apostila.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: "cadastro", component: CadastroComponent },
  { path: "login", component: LoginComponent },
  { path: "cadastroQuestoes", component: CadastroQuestoesComponent },
  { path: "questoes", component: QuestoesComponent },
  { path: "perfil", component: PerfilComponent},
  { path: "videos", component: AulasComponent },
  { path: "apostila", component: ApostilaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }
