import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { HistoriqueService, HistoriqueRetour } from '../../services/historique';
import { RetourService, RetourProduit } from '../../services/retour';

@Component({
  selector: 'app-historique-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './historique-form.html',
  styleUrl: './historique-form.css'
})
export class HistoriqueFormComponent implements OnInit {

  historique: HistoriqueRetour = {
    action: 'Validé',
    employe: '',
    date: '',
    retourId: 0
  };

  retours: RetourProduit[] = [];
  message: string = '';
  erreur: string = '';

  constructor(
    private historiqueService: HistoriqueService,
    private retourService: RetourService
  ) {}

  ngOnInit(): void {
    this.retourService.getAll().subscribe(data => {
      this.retours = data;
    });
  }

  submit(): void {
    this.message = '';
    this.erreur = '';
    this.historiqueService.create(this.historique).subscribe({
      next: () => {
        this.message = 'Historique ajouté avec succès !';
        this.historique = {
          action: 'Validé',
          employe: '',
          date: '',
          retourId: 0
        };
      },
      error: () => {
        this.erreur = 'Erreur : vérifiez que tous les champs sont remplis.';
      }
    });
  }
}