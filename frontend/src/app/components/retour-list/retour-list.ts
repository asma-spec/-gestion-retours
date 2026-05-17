import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { RetourService, RetourProduit } from '../../services/retour';

@Component({
  selector: 'app-retour-list',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './retour-list.html',
  styleUrl: './retour-list.css'
})
export class RetourListComponent implements OnInit {

  retours: RetourProduit[] = [];
  retourEnEdition: RetourProduit | null = null;
  retourATraiter: RetourProduit | null = null;
  employeQualite: string = '';
  nouvelEtat: string = 'Traité';
  message: string = '';

  constructor(private retourService: RetourService) {}

  ngOnInit(): void {
    this.chargerRetours();
  }

  chargerRetours(): void {
    this.retourService.getAll().subscribe(data => {
      this.retours = data;
    });
  }

  delete(id: number): void {
    if(confirm('Voulez-vous vraiment supprimer ce retour ?')) {
      this.retourService.delete(id).subscribe(() => {
        this.retours = this.retours.filter(r => r.id !== id);
      });
    }
  }

  editer(retour: RetourProduit): void {
    this.retourEnEdition = { ...retour };
    this.retourATraiter = null;
  }

  annulerEdition(): void {
    this.retourEnEdition = null;
  }

  sauvegarder(): void {
    if(this.retourEnEdition && this.retourEnEdition.id) {
      this.retourService.update(this.retourEnEdition.id, this.retourEnEdition).subscribe(() => {
        this.chargerRetours();
        this.retourEnEdition = null;
      });
    }
  }

  ouvrirTraitement(retour: RetourProduit): void {
    this.retourATraiter = retour;
    this.retourEnEdition = null;
    this.employeQualite = '';
    this.nouvelEtat = 'Traité';
    this.message = '';
  }

  annulerTraitement(): void {
    this.retourATraiter = null;
  }

  validerTraitement(): void {
    if(this.retourATraiter && this.retourATraiter.id && this.employeQualite) {
      this.retourService.traiter(
        this.retourATraiter.id,
        this.nouvelEtat,
        this.employeQualite
      ).subscribe(() => {
        this.message = 'Retour traité avec succès !';
        this.retourATraiter = null;
        this.chargerRetours();
      });
    }
  }
}