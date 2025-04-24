import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface User {
  id: number;
  alias: string;
  profilPictureUrl: string;
  biography: string;
}

@Injectable({
    providedIn: 'root',
  })
export class UserService {
    private readonly apiUrl = `http://localhost:8080/api`;

  constructor(private http: HttpClient) {}

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiUrl}/users`);
  }
}