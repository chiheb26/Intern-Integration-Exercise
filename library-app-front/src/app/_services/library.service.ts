import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/Book';

const LIBRARY_API = 'http://localhost:8081/api/v1/books/';
@Injectable({
  providedIn: 'root'
})

export class LibraryService {
  constructor(private http: HttpClient) {}
      
  
  findBookById(id:number): Observable<Book> {
    return this.http.get<Book>(LIBRARY_API + id);
  }

  findAllBooksByLibraryName(libName:string):Observable<Book[]>{
    return this.http.get<Book[]>(LIBRARY_API+"library/"+libName);
  }
}
