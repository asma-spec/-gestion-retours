import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RetourService, RetourProduit } from '../../services/retour';

@Component({
  selector: 'app-retour-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './retour-form.html',
  styleUrl: './retour-form.css'
})
export class RetourFormComponent {

  retour: RetourProduit = {
    produit: '',
    client: '',
    raison: '',
    etatTraitement: 'En cours',
    date: ''
  };

  message: string = '';
  erreur: string = '';

  constructor(private retourService: RetourService) {}

  submit(): void {
    this.message = '';
    this.erreur = '';
    this.retourService.create(this.retour).subscribe({
      next: () => {
        this.message = 'Retour créé avec succès !';
        this.retour = {
          produit: '',
          client: '',
          raison: '',
          etatTraitement: 'En cours',
          date: ''
        };
      },
      error: () => {
        this.erreur = 'Erreur : vérifiez que tous les champs sont remplis.';
      }
    });
  }
}