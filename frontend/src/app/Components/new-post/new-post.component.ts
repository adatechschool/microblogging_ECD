import { Component } from '@angular/core';

@Component({
  selector: 'app-new-post',
  imports: [],
  templateUrl: './new-post.component.html',
  styleUrl: './new-post.component.css'
})
export class NewPostComponent {
  searchText: string = '';

  onSearch(): void {
    console.log('Recherche :', this.searchText);
    // Appeler ici un service ou émettre un event
  }
}
