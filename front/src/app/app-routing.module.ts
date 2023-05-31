import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarComponent } from './components/usuarios/listar/listar.component';
import { AgregarComponent } from './components/usuarios/agregar/agregar.component';


const routes: Routes = [
  {path : 'usuarios/listar', component : ListarComponent},
  {path : 'usuarios/agregar', component : AgregarComponent},
  { path: '**', redirectTo: 'usuarios/listar' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
