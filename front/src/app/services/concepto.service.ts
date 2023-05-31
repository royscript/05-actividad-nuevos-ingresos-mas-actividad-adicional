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
}
