import { Component, OnInit } from '@angular/core';
import { Book } from './models/Book';
import { BookType } from './models/enums/BookType';
import { LibraryService } from './_services/library.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title = 'library-app-front';
  activeTab?:string;
  books?:Book[];
  filteredBooks?:Book[];
  novels?:Book[];
  magazines?:Book[];
  
  constructor(private libraryService:LibraryService) { }
  
  ngOnInit() {
    this.activeTab="novels";
    this.libraryService.findAllBooksByLibraryName("The Artists").subscribe({
      next: value => {
        this.books = value; 
       // console.log(value);
      },
      error: err => console.log(err)
    });
    //console.log(this.books);
  }

  onActiveTabChanged(data:string){
    this.activeTab=data;

  }

}
