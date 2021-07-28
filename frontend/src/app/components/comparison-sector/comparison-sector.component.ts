import { Component, OnInit, ElementRef } from '@angular/core';
import { Chart } from 'chart.js';

import { Comparison } from '../../models/Comparison';
import { StockPriceService } from '../../services/stock-price.service';

@Component({
  selector: 'app-comparison-sector',
  templateUrl: './comparison-sector.component.html',
  styleUrls: ['./comparison-sector.component.css']
})
export class ComparisonSectorComponent implements OnInit {
  chart: any = [];

  comparison: Comparison = {
    name: '',
    stockExchangeName: '',
    fromPeriod: '',
    toPeriod: '',
    periodicity: ''
  }

  constructor(private stockPriceService: StockPriceService, private elementRef: ElementRef) { }

  ngOnInit(): void {
  }

  onSubmit({ value, valid }: { value: Comparison, valid: boolean }) {
    this.stockPriceService.getSectorStockPrices(value)
      .subscribe(response => {
        let pricesList = response.map(res => res.price);
        let datesList = response.map(res => res.currentPriceDate);
        let htmlRef = (<HTMLCanvasElement>document.getElementById("canvasId")).getContext('2d');
        this.chart = new Chart(htmlRef, {
          type: 'line',
          data: {
            labels: datesList,
            datasets: [
              {
                data: pricesList,
                borderColor: "green",
                fill: false
              }
            ]
          },
          options: {
            legend: {
              display: true
            },
            scales: {
              xAxes: [{
                display: true
              }],
              yAxes: [{
                display: true
              }],
            }
          }
        });
      });

  }

}
