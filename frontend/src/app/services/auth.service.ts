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
  private tokenTimer: any;
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
        console.log(response);
        if (response.token) {
          this.token = response.token;
          //const expiresInDuration = response.expiresIn;
          //this.setAuthTimer(expiresInDuration);
          this.isAuthenticated = true;
          //this.admin = response.admin;
          //this.username = response.username;
          const now = new Date();
          const expirationDate = new Date(now.getTime() + 1000000);
          this.saveAuthData(this.token, expirationDate, this.username, this.admin);
          console.log(this.token, 10, this.username, this.admin);
          this.authStatusListener.next(true);
          this.router.navigate(['/']);
        }
      }, error => {
        console.log(error);
        console.log(error.error);
        this.authStatusListener.next(false);
      });
  }

  autoAuthUser() {
    const authInformation = this.getAuthData();
    if (!authInformation) {
      return;
    }
    const now = new Date();
    const expiresIn = authInformation.expirationDate.getTime() - now.getTime();
    if (expiresIn > 0) {
      this.token = authInformation.token;
      this.isAuthenticated = true;
      this.username = authInformation.username;
      this.admin = authInformation.admin;
      this.setAuthTimer(expiresIn);
      this.authStatusListener.next(true);
    }
  }

  logout() {
    this.token = null;
    this.isAuthenticated = false;
    this.admin = false;
    this.authStatusListener.next(false);
    clearTimeout(this.tokenTimer);
    this.clearAuthData();
    this.username = null;
    this.router.navigate(['/']);
  }

  private setAuthTimer(duration: number) {
    this.tokenTimer = setTimeout(() => {
      this.logout();
    }, duration * 1000);
  }

  private saveAuthData(token: string, expirationDate: Date, username: string, admin: boolean) {
    localStorage.setItem('token', token);
    localStorage.setItem('expiration', expirationDate.toISOString());
    localStorage.setItem('username', username);
    if (admin) {
      localStorage.setItem('admin', "admin");
    }
  }

  private clearAuthData() {
    localStorage.removeItem('token');
    localStorage.removeItem('expiration');
    localStorage.removeItem('username');
    localStorage.removeItem('admin');
  }

  private getAuthData() {
    const token = localStorage.getItem('token');
    const expirationDate = localStorage.getItem('expiration');
    const username = localStorage.getItem('username');
    const admin = localStorage.getItem('admin') ? true : false;
    if (!token || !expirationDate || !username) {
      return;
    }
    return {
      token: token,
      expirationDate: new Date(expirationDate),
      username: username,
      admin: admin
    };
  }
}
