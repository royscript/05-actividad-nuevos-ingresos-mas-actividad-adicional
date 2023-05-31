import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListarComponent } from './listar/listar.component';
import { AgregarComponent } from './agregar/agregar.component';
import { RouterModule } from '@angular/router';
import { DataTablesModule } from "angular-datatables";
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ConceptoComponent } from '../concepto/concepto.component';
import { NgSelectModule } from '@ng-select/ng-select';
@NgModule({
  declarations: [ListarComponent, AgregarComponent, ConceptoComponent],
  imports: [
    CommonModule,
    RouterModule, // Rutas dinamicas
    DataTablesModule, // Datatables
    HttpClientModule, // Cliente Http
    FormsModule, // Formularios
    NgbModule,
    ReactiveFormsModule, // Formularios reactivos
    NgSelectModule //ng-Select
  ]
})
export class UsuarioModule { }
