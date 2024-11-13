// postulante.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostulanteService {

  private API_URL = 'http://localhost:8080/api/v1/postulante/create';  // URL de la API

  constructor(private httpClient: HttpClient) { }

  // Método para enviar la solicitud POST
  public savePostulante(postulante: any): Observable<any> {
    return this.httpClient.post(this.API_URL, postulante);
  }
}
