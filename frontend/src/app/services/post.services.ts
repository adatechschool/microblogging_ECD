import { PostCard } from "../models/card-post";
// import { UserCard } from "../models/user-card";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map, Observable, of } from 'rxjs';
import { Media } from "../models/media";

@Injectable({
    providedIn: 'root',
  })
export class PostService {
    private readonly apiUrl = `http://localhost:8080/api`;

    constructor(private readonly http: HttpClient) {}

    getPosts(): Observable<PostCard[]> {
        return this.http.get<any>(`${this.apiUrl}/posts`).pipe(
          map((response) => {
            // Si l'API renvoie un objet unique, le transformer en tableau
            if (!Array.isArray(response)) {
              const PostCard: PostCard = {
                id: response.id || 0,
                user: response.user || '',
                description: response.description || '',
                createdAt: response.createdAt || '',
              };
    
              return [PostCard];
            }
    
            // Si l'API renvoie déjà un tableau
            return response.map((item: any) => ({
              id: item.id || 0,
              user: item.user || '',
              description: item.description || '',
              createdAt: item.createdAt || '',
            }));
          })
        );
      }

    getMedias(): Observable<Media[]> {
      return this.http.get<any>(`${this.apiUrl}/media`).pipe(
        map((response) => {
          // Si l'API renvoie un objet unique, le transformer en tableau
          if (!Array.isArray(response)) {
            const Media: Media = {
              id: response.id || 0,
              mediaUrl: response.mediaUrl || '',
            };
          
            return [Media];
          }
          console.log(response)
          // Si l'API renvoie déjà un tableau
          return response.map((item: any) => ({
            id: item.id || 0,
            mediaUrl: item.mediaUrl || '',
          }));
        })
      );
    }

    createPost(postData: any): Observable<PostCard> {
        return this.http.post<PostCard>(`${this.apiUrl}/posts`, postData);
    }
}