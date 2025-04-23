import { Component , OnInit } from '@angular/core';
import { CardPostComponent } from '../../Components/card-post/card-post.component';
import { UserCardComponent } from '../../Components/user-card/user-card.component';
import { SearchBarComponent } from '../../Components/search-bar/search-bar.component';
import { PostService } from '../../services/post.services';
import { CardPost } from '../../models/card-post';


@Component({
  selector: 'app-home-page',
  imports: [CardPostComponent, UserCardComponent, SearchBarComponent],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent implements OnInit {

  cardPost: CardPost[] = [];
  loading = true;
  error = false;

  constructor(private readonly postService: PostService) {}

  ngOnInit(): void {
    this.loadPosts();
  }

  private loadPosts() {
    this.postService.getPosts().subscribe({
      next: (data) => {
        this.cardPost = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Erreur lors de la récupération des données', err);
        this.error = true;
        this.loading = false;
      },
    });
  }

}
