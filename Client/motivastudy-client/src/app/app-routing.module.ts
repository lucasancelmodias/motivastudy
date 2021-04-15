import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { from } from 'rxjs';

// Importação dos componentes das páginas 
import { HomeComponent } from "./pages/home/home.component";
import { CadastroComponent } from "./pages/cadastro/cadastro.component";
import { LoginComponent } from "./pages/login/login.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: "cadastro", component: CadastroComponent },
  { path: "login", component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
  
  
export class AppRoutingModule { }
