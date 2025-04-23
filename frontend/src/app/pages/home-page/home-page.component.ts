import { Component, OnInit } from '@angular/core';
import { CardPostComponent } from '../../Components/card-post/card-post.component';
import { UserCardComponent } from '../../Components/user-card/user-card.component';
import { SidebarLeftComponent } from '../../Components/sidebar-left/sidebar-left.component';
import { SidebarRightComponent } from "../../Components/sidebar-right/sidebar-right.component";
import { SearchBarComponent } from "../../Components/search-bar/search-bar.component";
import { PostCard } from '../../models/card-post';
import { CommonModule } from '@angular/common';
import { PostService } from '../../Services/post.services';
import { HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-home-page',
  imports: [CardPostComponent, UserCardComponent, SidebarLeftComponent, SidebarRightComponent, SearchBarComponent, CommonModule],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})

export class HomePageComponent implements OnInit { 
  cardPosts: PostCard[] = [];
  loading = true;
  error = false;
  constructor(private readonly postService: PostService) {}
  ngOnInit(): void {
    this.loadPosts();
  }
  private loadPosts() {
    this.postService.getPosts().subscribe({
      next: (data) => {
        this.cardPosts = data;
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
