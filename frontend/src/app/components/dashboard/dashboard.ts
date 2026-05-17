import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { RetourService, RetourProduit } from '../../services/retour';
import { NonConformiteService, NonConformite } from '../../services/nonconformite';
import { UtilisateurService, Utilisateur } from '../../services/utilisateur';
import { HistoriqueService, HistoriqueRetour } from '../../services/historique';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class DashboardComponent implements OnInit {

  // Retours
  totalRetours: number = 0;
  retoursEnCours: number = 0;
  retoursTraites: number = 0;
  retoursRejetes: number = 0;
  retoursEnStock: number = 0;
  stockTotal: number = 0;

  // NonConformités
  totalNonConformites: number = 0;
  ncFaible: number = 0;
  ncMoyenne: number = 0;
  ncElevee: number = 0;

  // Utilisateurs
  totalUtilisateurs: number = 0;
  totalAdmins: number = 0;
  totalQualite: number = 0;

  // Historique
  totalHistoriques: number = 0;

  constructor(
    private retourService: RetourService,
    private ncService: NonConformiteService,
    private utilisateurService: UtilisateurService,
    private historiqueService: HistoriqueService
  ) {}

  ngOnInit(): void {
    // Charger les retours
    this.retourService.getAll().subscribe((data: RetourProduit[]) => {
      this.totalRetours = data.length;
      this.retoursEnCours = data.filter(r => r.etatTraitement === 'En cours').length;
      this.retoursTraites = data.filter(r => r.etatTraitement === 'Traité').length;
      this.retoursRejetes = data.filter(r => r.etatTraitement === 'Rejeté').length;
      this.retoursEnStock = data.filter(r => r.etatTraitement === 'Retourné en stock').length;
      this.stockTotal = data.reduce((acc, r) => acc + (r.quantiteStock || 0), 0);
    });

    // Charger les non-conformités
    this.ncService.getAll().subscribe((data: NonConformite[]) => {
      this.totalNonConformites = data.length;
      this.ncFaible = data.filter(n => n.gravite === 'faible').length;
      this.ncMoyenne = data.filter(n => n.gravite === 'moyenne').length;
      this.ncElevee = data.filter(n => n.gravite === 'élevée').length;
    });

    // Charger les utilisateurs
    this.utilisateurService.getAll().subscribe((data: Utilisateur[]) => {
      this.totalUtilisateurs = data.length;
      this.totalAdmins = data.filter(u => u.role === 'ADMIN').length;
      this.totalQualite = data.filter(u => u.role === 'QUALITE').length;
    });

    // Charger les historiques
    this.historiqueService.getAll().subscribe((data: HistoriqueRetour[]) => {
      this.totalHistoriques = data.length;
    });
  }
}