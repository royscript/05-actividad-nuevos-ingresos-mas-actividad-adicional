import { AfterViewInit, Component, OnDestroy, OnInit, ViewChild, Renderer } from '@angular/core';
import { DataTableDirective } from 'angular-datatables';
import { Subject } from 'rxjs';
import { Usuario } from 'src/app/models/usuario.model';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';



@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.scss']
})
export class ListarComponent implements OnInit, AfterViewInit, OnDestroy {
  // Declaracion de variables
  usuarios?: Usuario[];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  exito?: string;
  error?: string;
  cargando?: boolean;
  instanciaActual = this;

  @ViewChild(DataTableDirective, { static: false })
  dtElement: DataTableDirective;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router,
    private renderer: Renderer,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    // Parametros tabla datatables
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      columns: [{
        title: 'ID',
        data: 'ccrUsuario'
      }, {
        title: 'Nombre',
        data: 'glsUsername'
      }, {
        title: 'Action',
        render: (data: any, type: any, full: any) => {
          return `<button type="button" id="btnEditar" class="btn btn-sm btn-primary">Editar</button>
                  <button type="button" id="btnEliminar" class="btn btn-sm btn-danger">Eliminar</button>
          `;
        }
      }],
      rowCallback: (row: Node, data: any[], index: number) => {
        $('#btnEliminar', row).bind('click', () => {
          if (data) {
            this.eliminar(data as Usuario);
          }
        });
        $('#btnEditar', row).bind('click', () => {
          this.redireccionarEditar(data); // Redireccionar al hacer clic en la fila
        });
        return row;
      }
    };

    // Recepcion de variables desde agregar
    this.exito = history.state.exito;
    this.ocultarSuccess();
    this.error = history.state.error;
    this.ocultarErrors();
    history.replaceState({ ...history.state, exito: null }, '');
    history.replaceState({ ...history.state, error: null }, '');
  }

  ngAfterViewInit(): void {
    this.listarTodos();
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }
  //Metodos
  ocultarErrors() {
    /* Se le agrego instancia ya que adentro de setTimeOut this hace referencia a setTimeOut */
    setTimeout(() => {
      this.instanciaActual.error = null;
    }, 3000);
  }
  ocultarSuccess(){
    /* Se le agrego instancia ya que adentro de setTimeOut this hace referencia a setTimeOut */
    setTimeout(() => {
      this.instanciaActual.exito = null;
    }, 3000);
  }
  eliminar(data: Usuario) {
    const confirmacion = window.confirm('¿Estás seguro de que deseas eliminar este usuario?');
    if (confirmacion) {
      this.usuarioService.eliminar(data).subscribe(
        usuarios => {
          this.recargarTabla();
          this.exito = `Registro Eliminado Correctamente`;
          this.ocultarSuccess();
        },
        error => {
          this.error = `Error al obtener usuarios: ${error}`;
          this.ocultarErrors();
        }
      );
    }
  }
  
  listarTodos() {
    this.usuarioService.listar().subscribe(
      usuarios => {
        this.usuarios = usuarios;
        /* Asignamos los registros a la data de datatables */
        this.dtOptions.data = usuarios;
        /* Refrescamos datatables */
        this.dtTrigger.next();
      },
      error => {
        console.log('Error al obtener usuarios:', error);
      }
    );
  }
  recargarTabla(): void {
    /* Este método se utiliza para volver a renderizar DataTables */
    this.dtElement.dtInstance.then((dtInstance: DataTables.Api) => {
      if (dtInstance) {
        dtInstance.destroy();
      }
      // dtInstance.clear();
      this.listarTodos();
    });
  }
  rerender(): void {
    /* El presente metodo sirve para volver a renderizar datatables */
    this.dtElement.dtInstance.then((dtInstance: DataTables.Api) => {
      dtInstance.destroy();
      this.dtTrigger.next();
    });
  }
  redireccionarEditar(data: any): void {
    this.router.navigate(['/usuarios/agregar'], { state: { usuario: data as Usuario } });
  }
}
