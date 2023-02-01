import { Component, Input, OnInit } from '@angular/core';
import { Book } from '../models/Book';
import { BookType } from '../models/enums/BookType';
import { LibraryService } from '../_services/library.service';

@Component({
  selector: 'app-magazine',
  templateUrl: './magazine.component.html',
  styleUrls: ['./magazine.component.css']
})
export class MagazineComponent implements OnInit {
 
  libName?:string;
  magazines?:Book[];
  
  constructor(private service: LibraryService) { }

  ngOnInit(): void {
    this.service.findAllBooksByLibraryName("The Artists").subscribe( {next: value => {
      this.magazines = value; 
      this.magazines=this.magazines?.filter(book=>book.bookType==BookType.MAGAZINE);
      this.libName=this.magazines[0].library?.name;
      

    },
   error: err => console.log(err)});
  }
  

}
