import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { Observable } from 'rxjs';
import { IPO } from '../models/IPO';


@Injectable({ providedIn: 'root' })
export class IpoService {

  url: string;

  constructor(private http: HttpClient, private router: Router) {
    this.url = "http://localhost:8087/company"
  }

  public getIpos(): Observable<IPO[]> {
    return this.http.get<IPO[]>(this.url + "/ipo/getIpo");
  }

  getIpo(id: string): Observable<IPO> {
    return this.http.get<IPO>(this.url + "/ipo/" + id);
  }

  addIpo(ipo: IPO) {
    this.http.post<IPO>(this.url + "/ipo/add", ipo)
      .subscribe((responseData) => {
        this.router.navigate(['/ipos']);
      });
  }

  updateIpo(ipo: IPO) {
    this.http.put(this.url + "/ipo/update", ipo)
      .subscribe(response => {
        this.router.navigate(['/ipos']);
      });
  }

  deleteIpo(id: string) {
    this.http.delete(this.url + "/ipo/delete/" + id)
      .subscribe(response => {
        this.router.navigate(['/ipos']);
      });
  }
}

