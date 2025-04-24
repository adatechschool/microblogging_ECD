import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface SearchResult {
  users: any[];
  posts: any[];
}

@Injectable({ providedIn: 'root' })
export class SearchService {
  private baseUrl = '/api/search';

  constructor(private http: HttpClient) {}

  search(query: string): Observable<SearchResult> {
    const params = new HttpParams().set('q', query);
    return this.http.get<SearchResult>(this.baseUrl, { params });
  }
}