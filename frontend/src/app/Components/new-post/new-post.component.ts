// new-post.component.ts
import {
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
} from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  FormArray,
  ReactiveFormsModule,
} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Ajoutez cet import

@Component({
  selector: 'app-new-post',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule], // Ajoutez FormsModule ici
  templateUrl: './new-post.component.html',
  styleUrl: './new-post.component.css'
})
export class NewPostComponent implements OnInit {
  @Input() initialData: any = null;
  @Output() formSubmit: EventEmitter<any> = new EventEmitter<any>();
  
  postForm!: FormGroup;
  error: string = '';
  searchText: string = '';

  constructor(private readonly fb: FormBuilder) {}

  ngOnInit(): void {
    this.buildForm();
    if (this.initialData) {
      this.populateForm(this.initialData);
    }
  }

  private buildForm(): void {
    this.postForm = this.fb.group({
      description: ['', Validators.required],
      imageUrls: this.fb.array([this.fb.control('')])
    });
  }

  private populateForm(data: any): void {
    this.postForm.patchValue({
      description: data.description
    });
    
    const imageUrlsArray = this.postForm.get('imageUrls') as FormArray;
    imageUrlsArray.clear();
    
    if (data.imageUrls && data.imageUrls.length > 0) {
      data.imageUrls.forEach((url: string) => {
        imageUrlsArray.push(this.fb.control(url));
      });
    } else {
      imageUrlsArray.push(this.fb.control(''));
    }
  }

  get imageUrls(): FormArray {
    return this.postForm.get('imageUrls') as FormArray;
  }

  addImageUrl(): void {
    this.imageUrls.push(this.fb.control(''));
  }

  removeImageUrl(index: number): void {
    this.imageUrls.removeAt(index);
  }

  onSearch(): void {
    console.log('Recherche :', this.searchText);
    // Appeler ici un service ou émettre un event
  }

  submit(): void {
    if (this.postForm.invalid) {
      this.error = 'Veuillez ajouter une description.';
      return;
    }
    this.error = '';
    this.formSubmit.emit(this.postForm.value);
  }
}