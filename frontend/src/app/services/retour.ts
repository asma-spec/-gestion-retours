import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface RetourProduit {
  id?: number;
  produit: string;
  client: string;
  raison: string;
  etatTraitement: string;
  date: string;
  quantiteStock?: number;
}

export interface TraitementRequest {
  etat: string;
  employe: string;
}

@Injectable({
  providedIn: 'root'
})
export class RetourService {

  private apiUrl = 'http://localhost:8080/api/retours';

  constructor(private http: HttpClient) {}

  getAll(): Observable<RetourProduit[]> {
    return this.http.get<RetourProduit[]>(this.apiUrl);
  }

  getById(id: number): Observable<RetourProduit> {
    return this.http.get<RetourProduit>(`${this.apiUrl}/${id}`);
  }

  create(retour: RetourProduit): Observable<RetourProduit> {
    return this.http.post<RetourProduit>(this.apiUrl, retour);
  }

  update(id: number, retour: RetourProduit): Observable<RetourProduit> {
    return this.http.put<RetourProduit>(`${this.apiUrl}/${id}`, retour);
  }

  traiter(id: number, etat: string, employe: string): Observable<RetourProduit> {
    return this.http.put<RetourProduit>(`${this.apiUrl}/${id}/traiter`, { etat, employe });
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}