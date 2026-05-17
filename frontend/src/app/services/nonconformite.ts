import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface NonConformite {
  id?: number;
  description: string;
  gravite: string;
  date: string;
  produit: string;
}

@Injectable({
  providedIn: 'root'
})
export class NonConformiteService {

  private apiUrl = 'http://localhost:8080/api/nonconformites';

  constructor(private http: HttpClient) {}

  getAll(): Observable<NonConformite[]> {
    return this.http.get<NonConformite[]>(this.apiUrl);
  }

  getById(id: number): Observable<NonConformite> {
    return this.http.get<NonConformite>(`${this.apiUrl}/${id}`);
  }

  create(nc: NonConformite): Observable<NonConformite> {
    return this.http.post<NonConformite>(this.apiUrl, nc);
  }

  update(id: number, nc: NonConformite): Observable<NonConformite> {
    return this.http.put<NonConformite>(`${this.apiUrl}/${id}`, nc);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}