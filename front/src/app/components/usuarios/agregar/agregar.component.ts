import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario.model';
import { FormControl, Validators, FormGroup, FormBuilder } from '@angular/forms'; /* Formularios Reactivos */
import { UsuarioService } from 'src/app/services/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.scss']
})
export class AgregarComponent implements OnInit {
  usuarioEditar?: Usuario;
  usuario?: Usuario;
  nombreBoton = 'Agregar';
  usuarioForm?: FormGroup;

  constructor(
    private fb: FormBuilder,
    private usuarioService: UsuarioService,
    private router: Router
  ) {
    // ----------Definicion del formulario y validaciones
    this.usuarioForm = this.fb.group({
      glsUsername : [this.usuario && this.usuario.glsUsername || null, [Validators.required, Validators.minLength(7)]],
      rut : [this.usuario && this.usuario.rut || null, [Validators.required, Validators.minLength(7)]],
      rutDiv : [this.usuario && this.usuario.rutDiv || null, [Validators.required, Validators.minLength(1)]],
      concepto : [this.usuario && this.usuario.concepto || null, [Validators.required]]
    });
  }
  ngOnInit(): void {
    this.usuarioEditar = history.state.usuario; /* Recepcionamos los datos del usuario en caso de editar */
    if (typeof this.usuarioEditar !== 'undefined') {/* Si se encuentra la causa con datos */
      this.usuarioForm.patchValue({/* Asignamos al campo del formulario */
          glsUsername: this.usuarioEditar.glsUsername,
          rut: this.usuarioEditar.rut,
          rutDiv: this.usuarioEditar.rutDiv,
          concepto: this.usuarioEditar.concepto
    });
      this.nombreBoton = 'Editar';
      // Limpiar los valores en el historial de navegación
      history.replaceState({ ...history.state, usuario: null }, '');
    }
  }
  // Metodos Getter del formulario
  get userName() {
    return this.usuarioForm.get('glsUsername') as FormControl;
  }
  get rut() {
    return this.usuarioForm.get('rut') as FormControl;
  }
  get div() {
    return this.usuarioForm.get('rutDiv') as FormControl;
  }
  get concepto() {
    return this.usuarioForm.get('concepto') as FormControl;
  }
  setConcepto(selectedConcepto: any) {
    this.usuarioForm.patchValue({/* Asignamos al campo del formulario */
          concepto: selectedConcepto
    });
  }
  // Metodo submit del formulario
  onSubmit(value: FormGroup) {
    if (typeof this.usuarioEditar !== 'undefined') {/* Si existe un usuario para editar  */
      this.editar(value);
    } else {
      this.agregar(value);
    }
  }
  // Metodos de llamado APIS
  agregar(value: FormGroup) {
    if (value.status === 'VALID'){
      this.usuarioService.agregar(value.value).subscribe(data => {
        if (data) {
          this.router.navigate(['/usuarios/listar'], { state: { exito: `Usuario agregado correctamente` } });
        }
      },
      error => {
        this.router.navigate(['/usuarios/listar'], { state: { error: `Ocurrió un error al agregar al usuario: ${error}` } });
      });
    }
  }
  editar(value: FormGroup) {
    if (value.status === 'VALID') {
      // Agregamos los campos faltantes al objeto y enviamos
      const c = { ...this.usuarioEditar, ...value.value  };
      this.usuarioService.editar(c).subscribe(data => {
        if (data) {
          this.router.navigate(['/usuarios/listar'], { state: { exito: `Usuario editado correctamente` } });
        }
      },
      error => {
        this.router.navigate(['/usuarios/listar'], { state: { error: `Ocurrió un error al editar al usuario: ${error}` } });
      });
    }
  }
}
