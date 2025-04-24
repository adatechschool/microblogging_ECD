import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PostCard } from '../../models/card-post';
import { PostService } from '../../Services/post.services';
import { dateTimestampProvider } from 'rxjs/internal/scheduler/dateTimestampProvider';
import { UserCard } from '../../models/user-card'; 
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-new-post',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule], // Ajoutez FormsModule ici
  templateUrl: './new-post.component.html',
  styleUrl: './new-post.component.css'
})
export class NewPostComponent {

  constructor(private readonly postService: PostService) {}

  //remplacer avec les données de l'utilisateur connecté
  userdata: UserCard = 
  {
    id: 1,
    alias: "User1",
    email: "user1@example.com",
    password: "",
    profilPictureUrl: "https://img.freepik.com/free-vector/blue-circle-with-white-user_78370-4707.jpg?t=st=1745410665~exp=1745414265~hmac=4ebab1e71efa3d1133b88ade9d9e588512da522e6cb421e676f92366022790e4&w=826",
    biography: ""
  }

  description: string = "Description du post";

  onPost(myInput : string): void {
    const postdata : object = {
      user: this.userdata,
      description: myInput,
      createdAt: new Date().toISOString()
    };
    this.postService.createPost(postdata).subscribe({
      next: (response) => {
        console.log('Post créé avec succès', response);
      },
      error: (error) => {
        console.error('Erreur lors de la création du post', error);
      }
    });
  }

}