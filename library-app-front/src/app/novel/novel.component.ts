import { Component, Input, OnInit } from '@angular/core';
import { Book } from '../models/Book';
import { BookType } from '../models/enums/BookType';
import { LibraryService } from '../_services/library.service';

@Component({
  selector: 'app-novel',
  templateUrl: './novel.component.html',
  styleUrls: ['./novel.component.css']
})
export class NovelComponent implements OnInit {
  
 libName?:string;
  novels?:Book[];

  constructor(private service:LibraryService) { }

  ngOnInit(): void {
    this.service.findAllBooksByLibraryName("The Artists").subscribe({next: value => {
      this.novels = value; 
      this.novels=this.novels?.filter(book=>book.bookType==BookType.NOVEL);
      this.libName=this.novels[0].library?.name;

    },
   error: err => console.log(err)});
  }


}
