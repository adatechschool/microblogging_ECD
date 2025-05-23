import { Component, Input } from '@angular/core';
import { PostCard } from '../../models/card-post';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'card-post',
  imports: [RouterModule
  ],
  templateUrl: './card-post.component.html',
  styleUrl: './card-post.component.css'
})
export class CardPostComponent {
  @Input() post!: PostCard;

}
