import { Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard';
import { RetourListComponent } from './components/retour-list/retour-list';
import { RetourFormComponent } from './components/retour-form/retour-form';
import { NonConformiteListComponent } from './components/nonconformite-list/nonconformite-list';
import { NonConformiteFormComponent } from './components/nonconformite-form/nonconformite-form';
import { UtilisateurListComponent } from './components/utilisateur-list/utilisateur-list';
import { UtilisateurFormComponent } from './components/utilisateur-form/utilisateur-form';
import { HistoriqueListComponent } from './components/historique-list/historique-list';
import { HistoriqueFormComponent } from './components/historique-form/historique-form';
import { StockComponent } from './components/stock/stock';

export const routes: Routes = [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'retours', component: RetourListComponent },
  { path: 'retours/ajouter', component: RetourFormComponent },
  { path: 'nonconformites', component: NonConformiteListComponent },
  { path: 'nonconformites/ajouter', component: NonConformiteFormComponent },
  { path: 'utilisateurs', component: UtilisateurListComponent },
  { path: 'utilisateurs/ajouter', component: UtilisateurFormComponent },
  { path: 'historiques', component: HistoriqueListComponent },
  { path: 'historiques/ajouter', component: HistoriqueFormComponent },
  { path: 'stock', component: StockComponent }
];