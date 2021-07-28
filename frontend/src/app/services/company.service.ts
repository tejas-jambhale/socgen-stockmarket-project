import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { Company } from '../models/Company';
import { Observable } from 'rxjs';
import { IPO } from '../models/IPO';


@Injectable({ providedIn: 'root' })
export class CompanyService {

  url: string;

  constructor(private http: HttpClient, private router: Router) {
    this.url = "http://localhost:8087/company"
  }

  getCompanies(): Observable<Company[]> {
    return this.http.get<Company[]>(this.url, { 'headers': { "Authorization": "Bearer " + localStorage.getItem("token") } });
  }

  getCompany(id: string): Observable<Company> {
    return this.http.get<Company>(this.url + "/getCompanyPrice" + id, { 'headers': { "Authorization": "Bearer " + localStorage.getItem("token") } });
  }
  //
  getCompanyIpoDetails(id: string): Observable<IPO> {
    return this.http.get<IPO>(this.url + "/ipo/" + id, { 'headers': { "Authorization": "Bearer " + localStorage.getItem("token") } });
  }

  addCompany(company: Company) {
    this.http.post<Company>(this.url + "/addCompany", company, { 'headers': { "Authorization": "Bearer " + localStorage.getItem("token") } })
      .subscribe((responseData) => {
        this.router.navigate(['/companies']);
      });
  }

  updateCompany(company: Company) {
    this.http.put(this.url + "/update", company, { 'headers': { "Authorization": "Bearer " + localStorage.getItem("token") } })
      .subscribe(response => {
        this.router.navigate(['/companies']);
      });
  }

  deleteCompany(id: string) {
    this.http.delete(this.url + "/delete/" + id, { 'headers': { "Authorization": "Bearer " + localStorage.getItem("token") } })
      .subscribe(response => {
        this.router.navigate(['/companies']);
      });
  }
}

