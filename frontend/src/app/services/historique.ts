import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface HistoriqueRetour {
  id?: number;
  action: string;
  employe: string;
  date: string;
  retourId: number;  // ← changé de retour: {id: number} à retourId: number
}

@Injectable({
  providedIn: 'root'
})
export class HistoriqueService {

  private apiUrl = 'http://localhost:8080/api/historiques';

  constructor(private http: HttpClient) {}

  getAll(): Observable<HistoriqueRetour[]> {
    return this.http.get<HistoriqueRetour[]>(this.apiUrl);
  }

  create(h: HistoriqueRetour): Observable<HistoriqueRetour> {
    return this.http.post<HistoriqueRetour>(this.apiUrl, h);
  }

  update(id: number, h: HistoriqueRetour): Observable<HistoriqueRetour> {
    return this.http.put<HistoriqueRetour>(`${this.apiUrl}/${id}`, h);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}