import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  url?: string;
  private httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};
  constructor(private http: HttpClient) {
    this.url = `http://localhost:8081/`;
  }
  listar(): Observable <Usuario[]> {
    return this.http.get<Usuario[]>(`${this.url}usuarios`);
  }
  agregar(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.url}usuarios`, usuario, this.httpOptions);
  }
  editar(usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(`${this.url}usuarios/${usuario.ccrUsuario}`, usuario, this.httpOptions);
  }

  eliminar(usuario: Usuario): Observable<Usuario> {
    return this.http.delete<Usuario>(`${this.url}usuarios/${usuario.ccrUsuario}`);
  }
}
