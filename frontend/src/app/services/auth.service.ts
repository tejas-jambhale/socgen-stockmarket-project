import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';

import { LoginData } from '../models/LoginData';
import { User } from '../models/User';

const BACKEND_URL = "http://localhost:9998" + '/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public isAuthenticated = false;
  private admin = false;
  private token: string;
  private username: string;
  private authStatusListener = new Subject<boolean>();

  constructor(public http: HttpClient, private router: Router) { }

  getToken() {
    return this.token;
  }

  getIsAuth() {
    return this.isAuthenticated;
  }

  setIsAuth() {
    this.isAuthenticated = true;
  }

  getUsername() {
    return this.username;
  }

  isAdmin() {
    return this.admin;
  }

  getAuthStatusListener() {
    return this.authStatusListener.asObservable();
  }

  createUser(user: User) {
    return this.http.post(BACKEND_URL + '/signup', user)
      .subscribe(() => {
        this.router.navigate(['/auth/login']);
      }, error => {
        this.authStatusListener.next(false);
      });
  }

  login(username: string, password: string) {
    const loginData: LoginData = {
      username: username,
      password: password
    };
    console.log(loginData);
    this.http.post<{ token: string }>
      (BACKEND_URL + '/login', loginData, { responseType: "json" })
      .subscribe(response => {
        if (response.token) {
          this.token = response.token;
          this.isAuthenticated = true;
          const now = new Date();
          const expirationDate = new Date(now.getTime() + 1000000);
          this.saveData(this.token, expirationDate, this.username, this.admin);
          this.authStatusListener.next(true);
          this.router.navigate(['/']);
        }
      }, error => {
        this.authStatusListener.next(false);
      });
  }

  private saveData(token: string, expirationDate: Date, username: string, admin: boolean) {
    localStorage.setItem('token', token);
    localStorage.setItem('expiration', expirationDate.toISOString());
    localStorage.setItem('username', username);
    if (admin) {
      localStorage.setItem('admin', "admin");
    }
  }
}
