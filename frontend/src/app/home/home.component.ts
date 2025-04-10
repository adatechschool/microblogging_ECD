// Dans home.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  standalone: true, // Si vous utilisez des composants standalone
  imports: [CommonModule, /* autres imports de composants */]
})
export class HomeComponent {
  // Votre code
}