import { Component } from '@angular/core';

@Component({
  selector: 'app-search-bar',
  imports: [],
  templateUrl: './search-bar.component.html',
  styleUrl: './search-bar.component.css'
})
export class SearchBarComponent {
  searchText: string = '';

  onSearch(): void {
    console.log('Recherche :', this.searchText);
    // Appeler ici un service ou émettre un event
  }
}
