import { PostCard } from "../models/card-post";
// import { UserCard } from "../models/user-card";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map, Observable, of } from 'rxjs';
import { UserCard } from "../models/user-card";

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
                mediaUrl: response.mediaUrl || '',
                description: response.description || '',
                createdAt: response.createdAt || '',
              };
    
              return [PostCard];
            }
    
            // Si l'API renvoie déjà un tableau
            return response.map((item: any) => ({
              id: item.id || 0,
              user: item.user || '',
              mediaUrl: item.mediaUrl || '',
              description: item.description || '',
              createdAt: item.createdAt || '',
            }));
          })
        );
      }

      // getUserById(id: number): Observable<UserCard> {
      //   return this.http.get<any>(`${this.apiUrl}/posts/${id}`).pipe(
      //     map((response) => ({
      //       ...response,
      //       user: response.userNames,
      //     }))
      //   );
      // }

} 