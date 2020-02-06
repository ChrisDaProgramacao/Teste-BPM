import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Pedido } from './pedido/pedido.model';

import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/pedidos';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  save(dados: Pedido): Observable<Pedido> {
    if (dados.id) {
      return this._update(dados);
    }

    return this._create(dados);
  }

  _create(dados: Pedido): Observable<Pedido> {
    return this.http.post<Pedido>(API_URL, JSON.stringify(dados), this.httpOptions);
  }

  _update(dados: Pedido): Observable<Pedido> {
    return this.http.put<Pedido>(API_URL, JSON.stringify(dados), this.httpOptions);
  }

  getPending(): Observable<Pedido> {
    return this.http.get<Pedido>(`${API_URL}/pendente`);
  }
  
  getFilteredValues(dados) {
    return this.http.get<Pedido[]>(`${API_URL}/status`, { params: { ...dados } });
  }

}
