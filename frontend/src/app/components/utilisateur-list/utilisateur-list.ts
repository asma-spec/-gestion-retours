import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { UtilisateurService, Utilisateur } from '../../services/utilisateur';

@Component({
  selector: 'app-utilisateur-list',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './utilisateur-list.html',
  styleUrl: './utilisateur-list.css'
})
export class UtilisateurListComponent implements OnInit {

  utilisateurs: Utilisateur[] = [];
  userEnEdition: Utilisateur | null = null;

  constructor(private service: UtilisateurService) {}

  ngOnInit(): void {
    this.service.getAll().subscribe(data => {
      this.utilisateurs = data;
    });
  }

  delete(id: number): void {
    if(confirm('Voulez-vous vraiment supprimer ?')) {
      this.service.delete(id).subscribe(() => {
        this.utilisateurs = this.utilisateurs.filter(u => u.id !== id);
      });
    }
  }

  editer(u: Utilisateur): void {
    this.userEnEdition = { ...u };
  }

  annulerEdition(): void {
    this.userEnEdition = null;
  }

  sauvegarder(): void {
    if(this.userEnEdition && this.userEnEdition.id) {
      this.service.update(this.userEnEdition.id, this.userEnEdition).subscribe(() => {
        this.service.getAll().subscribe(data => {
          this.utilisateurs = data;
          this.userEnEdition = null;
        });
      });
    }
  }
}