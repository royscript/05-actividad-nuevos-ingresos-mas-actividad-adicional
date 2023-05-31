import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Concepto } from '../models/concepto.model';

@Injectable({
  providedIn: 'root'
})
export class ConceptoService {
  url?: string;
  private httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};
  constructor(private http: HttpClient) {
    this.url = `http://localhost:8081/`;
  }
  listar(): Observable <Concepto[]> {
    return this.http.get<Concepto[]>(`${this.url}concepto`);
  }
  agregar(concepto: Concepto): Observable<Concepto> {
    return this.http.post<Concepto>(`${this.url}concepto`, concepto, this.httpOptions);
  }
  editar(concepto: Concepto): Observable<Concepto> {
    return this.http.put<Concepto>(`${this.url}concepto/${concepto.codConcepto}`, concepto, this.httpOptions);
  }

  eliminar(concepto: Concepto): Observable<Concepto> {
    return this.http.delete<Concepto>(`${this.url}concepto/${concepto.codConcepto}`);
  }
}
