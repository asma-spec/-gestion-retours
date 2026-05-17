import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { HistoriqueService, HistoriqueRetour } from '../../services/historique';

@Component({
  selector: 'app-historique-list',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './historique-list.html',
  styleUrl: './historique-list.css'
})
export class HistoriqueListComponent implements OnInit {

  historiques: HistoriqueRetour[] = [];

  constructor(private service: HistoriqueService) {}

  ngOnInit(): void {
    this.service.getAll().subscribe(data => {
      this.historiques = data;
    });
  }

  delete(id: number): void {
    if(confirm('Voulez-vous vraiment supprimer ?')) {
      this.service.delete(id).subscribe(() => {
        this.historiques = this.historiques.filter(h => h.id !== id);
      });
    }
  }
}