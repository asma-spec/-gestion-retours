import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NonConformiteService, NonConformite } from '../../services/nonconformite';

@Component({
  selector: 'app-nonconformite-list',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './nonconformite-list.html',
  styleUrl: './nonconformite-list.css'
})
export class NonConformiteListComponent implements OnInit {

  nonConformites: NonConformite[] = [];
  ncEnEdition: NonConformite | null = null;

  constructor(private service: NonConformiteService) {}

  ngOnInit(): void {
    this.service.getAll().subscribe(data => {
      this.nonConformites = data;
    });
  }

  delete(id: number): void {
    if(confirm('Voulez-vous vraiment supprimer ?')) {
      this.service.delete(id).subscribe(() => {
        this.nonConformites = this.nonConformites.filter(n => n.id !== id);
      });
    }
  }

  editer(nc: NonConformite): void {
    this.ncEnEdition = { ...nc };
  }

  annulerEdition(): void {
    this.ncEnEdition = null;
  }

  sauvegarder(): void {
    if(this.ncEnEdition && this.ncEnEdition.id) {
      this.service.update(this.ncEnEdition.id, this.ncEnEdition).subscribe(() => {
        this.service.getAll().subscribe(data => {
          this.nonConformites = data;
          this.ncEnEdition = null;
        });
      });
    }
  }
}