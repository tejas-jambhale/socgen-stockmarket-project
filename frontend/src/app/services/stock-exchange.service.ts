import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { Company } from '../models/Company';
import { Observable } from 'rxjs';
import { StockExchange } from '../models/StockExchange';

@Injectable({ providedIn: 'root' })
export class StockExchangeService {

  url: string;

  constructor(private http: HttpClient, private router: Router) {
    this.url = "http://localhost:8080/stockExchange/"
  }

  getStockExchanges(): Observable<StockExchange[]> {
    return this.http.get<StockExchange[]>(this.url + "/getExchangesList");
  }

  getStockExchange(id: string): Observable<StockExchange> {
    return this.http.get<StockExchange>(this.url + "/getExchangeData/" + id);
  }

  getStockExchangeCompanies(id: string): Observable<Company[]> {
    return this.http.get<Company[]>(this.url + "/getCompaniesFromExchange/" + id);
  }

  addStockExchange(stockExchange: StockExchange) {
    this.http.post<StockExchange>(this.url + "/addExchange", stockExchange)
      .subscribe((responseData) => {
        this.router.navigate(['/stock-exchanges']);
      });
  }

  updateStockExchange(stockExchange: StockExchange) {
    this.http.put(this.url + "/updateExchange", stockExchange)
      .subscribe(response => {
        this.router.navigate(['/stock-exchanges']);
      });
  }

  deleteStockExchange(id: string) {
    this.http.delete(this.url + "/deleteExchange/" + id)
      .subscribe(response => {
        this.router.navigate(['/stock-exchanges']);
      });
  }
}

