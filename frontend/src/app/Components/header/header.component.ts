import { Component } from '@angular/core';
import { SearchBarComponent } from "../search-bar/search-bar.component";
import { NewPostComponent } from "../new-post/new-post.component";

@Component({
  selector: 'app-header',
  imports: [SearchBarComponent, NewPostComponent],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  handlePostSubmission(postData: any): void {
    console.log('Post reçu dans le HeaderComponent:', postData);

}
}