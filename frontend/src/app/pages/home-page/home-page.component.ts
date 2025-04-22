import { Component } from '@angular/core';
import { CardPostComponent } from '../../Components/card-post/card-post.component';
import { UserCardComponent } from '../../Components/user-card/user-card.component';
import { SearchBarComponent } from '../../Components/search-bar/search-bar.component';


@Component({
  selector: 'app-home-page',
  imports: [CardPostComponent, UserCardComponent, SearchBarComponent],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {

}
