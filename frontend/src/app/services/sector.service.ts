import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { Company } from '../models/Company';
import { Observable } from 'rxjs';
import { Sector } from '../models/Sector';

@Injectable({ providedIn: 'root' })
export class SectorService {

  url: string;

  constructor(private http: HttpClient, private router: Router) {
    this.url = "http://localhost:8089/sector"
  }

  getSectors(): Observable<Sector[]> {
    return this.http.get<Sector[]>(this.url);
  }

  getSector(id: string): Observable<Sector> {
    return this.http.get<Sector>(this.url + "/getSectorDetails/" + id);
  }

  getSectorCompanies(id: string): Observable<Company[]> {
    return this.http.get<Company[]>(this.url + "/getSectorCompanies/" + id);
  }

  addSector(sector: Sector) {
    this.http.post<Sector>(this.url + "/add", sector)
      .subscribe((responseData) => {
        this.router.navigate(['/sectors']);
      });
  }

  updateSector(sector: Sector) {
    this.http.put(this.url + "/update", sector)
      .subscribe(response => {
        this.router.navigate(['/sectors']);
      });
  }
  //
  deleteSector(id: string) {
    this.http.delete(this.url + "/delete/" + id)
      .subscribe(response => {
        this.router.navigate(['/sectors']);
      });
  }
}

