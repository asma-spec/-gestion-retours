import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RetourService, RetourProduit } from '../../services/retour';

@Component({
  selector: 'app-stock',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './stock.html',
  styleUrl: './stock.css'
})
export class StockComponent implements OnInit {

  retours: RetourProduit[] = [];
  stockTotal: number = 0;

  constructor(private retourService: RetourService) {}

  ngOnInit(): void {
    this.retourService.getAll().subscribe(data => {
      this.retours = data.filter(r => r.quantiteStock! > 0);
      this.stockTotal = this.retours.reduce((acc, r) => acc + r.quantiteStock!, 0);
    });
  }
}