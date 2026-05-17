import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { UtilisateurService, Utilisateur } from '../../services/utilisateur';

@Component({
  selector: 'app-utilisateur-form',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './utilisateur-form.html',
  styleUrl: './utilisateur-form.css'
})
export class UtilisateurFormComponent {

  utilisateur: Utilisateur = {
    nom: '',
    email: '',
    role: 'USER'
  };

  message: string = '';
  erreur: string = '';

  constructor(private service: UtilisateurService) {}

  submit(): void {
    this.message = '';
    this.erreur = '';
    this.service.create(this.utilisateur).subscribe({
      next: () => {
        this.message = 'Utilisateur créé avec succès !';
        this.utilisateur = { nom: '', email: '', role: 'USER' };
      },
      error: () => {
        this.erreur = 'Erreur : vérifiez que tous les champs sont remplis.';
      }
    });
  }
}