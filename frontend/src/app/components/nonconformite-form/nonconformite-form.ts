import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { NonConformiteService, NonConformite } from '../../services/nonconformite';

@Component({
  selector: 'app-nonconformite-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './nonconformite-form.html',
  styleUrl: './nonconformite-form.css'
})
export class NonConformiteFormComponent {

  nc: NonConformite = {
    description: '',
    gravite: 'faible',
    date: '',
    produit: ''
  };

  message: string = '';
  erreur: string = '';

  constructor(private service: NonConformiteService) {}

  submit(): void {
    this.message = '';
    this.erreur = '';
    this.service.create(this.nc).subscribe({
      next: () => {
        this.message = 'Non-conformité créée avec succès !';
        this.nc = { description: '', gravite: 'faible', date: '', produit: '' };
      },
      error: () => {
        this.erreur = 'Erreur : vérifiez que tous les champs sont remplis.';
      }
    });
  }
}