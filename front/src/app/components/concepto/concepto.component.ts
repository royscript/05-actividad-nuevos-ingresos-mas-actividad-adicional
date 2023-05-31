import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Concepto } from 'src/app/models/concepto.model';
import { ConceptoService } from 'src/app/services/concepto.service';

@Component({
  selector: 'app-concepto',
  templateUrl: './concepto.component.html',
  styleUrls: ['./concepto.component.scss']
})
export class ConceptoComponent implements OnInit {
  @Input() value: any;
  @Output() selectChanged = new EventEmitter<any>();
  conceptos?: Concepto;
  selectedConcepto: number[] = [];

  constructor(private conceptoService: ConceptoService) { }

  ngOnInit() {
    this.getAll();
  }

  getAll(): void {
    this.conceptoService.listar().subscribe(
      concepto => {
        this.conceptos = concepto as Concepto; // Cuando se asignen los valores de los conceptos
        this.setValue(); // Si existe un seteo de valores se lo asignaremos
      },
      error => {
        console.log(error);
      }
    );
  }
  onChange() {
    this.selectChanged.emit(this.conceptos.filter( v => this.selectedConcepto === v.codConcepto)[0]);
  }
  setValue(): void {
    if (this.value && typeof this.value.codConcepto !== 'undefined') { // Si el valor trae codConcepto definido
        // Realizamos la busqueda y se lo asignamos al select
        this.selectedConcepto = (
                                    this.conceptos.findIndex(v => this.value.codConcepto === v.codConcepto) as number
                                ) + 1; // le sumamos 1 porque el combobox cuenta desde 1
    }
  }
}
