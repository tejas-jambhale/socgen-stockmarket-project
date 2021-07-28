import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { Observable } from 'rxjs';
import { StockPrice } from '../models/StockPrice';
import { Comparison } from '../models/Comparison';

@Injectable({ providedIn: 'root' })
export class StockPriceService {

  url: string;

  constructor(private http: HttpClient, private router: Router) {
    this.url = "http://localhost:8086/stockPrice"
  }

  public getStockPrices(): Observable<StockPrice[]> {
    return this.http.get<StockPrice[]>(this.url + "/getAllPrices");
  }

  getStockPrice(id: string): Observable<StockPrice> {
    return this.http.get<StockPrice>(this.url + "/getPrice/" + id);
  }

  addStockPriceList(stockPrices: StockPrice[]) {
    this.http.post<StockPrice[]>(this.url + "/addNewStockPriceList", stockPrices)
      .subscribe(response => response);
  }

  updateStockPrice(stockPrice: StockPrice) {
    this.http.put(this.url + "/update", stockPrice)
      .subscribe(response => {
        this.router.navigate(['/stock-prices']);
      });
  }

  deleteStockPrice(id: string) {
    this.http.delete(this.url + "/delete" + id)
      .subscribe(response => {
        this.router.navigate(['/stock-prices']);
      });
  }

  getCompanyStockPrices(comparsion: Comparison) {
    return this.http.get<StockPrice[]>(this.url + "/getCompanyPrices/" + comparsion.name + "/" + comparsion.stockExchangeName + "/" + comparsion.fromPeriod + "/" + comparsion.toPeriod);
  }

  getSectorStockPrices(comparsion: Comparison) {
    return this.http.get<StockPrice[]>(this.url + "/getSectorPrices/" + comparsion.name + "/" + comparsion.stockExchangeName + "/" + comparsion.fromPeriod + "/" + comparsion.toPeriod);
  }
}

