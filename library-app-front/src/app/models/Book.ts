import { Author } from "./Author";
import { Category } from "./Category";
import { BookType } from "./enums/BookType";
import { Library } from "./Library";

    export class Book{
        id?:number;
        bookType?:BookType;
        title?:string;
        price?:number;
        totalUnitsSold?:number;
        publicationDate?:Date;
        numberOfPages?:number;
        categories?:Category[];
        author!:Author;
        library?:Library;
        nextReleaseDate?:Date;
        keywords?:string[];
        storySummary?:string;
        
        constructor(){
            this.id=0;
            this.bookType=BookType.DEFAULT;
            this.title="";
            this.price=0;
            this.totalUnitsSold=0;
            this.numberOfPages=0;
            this.author=new Author();
            this.library=new Library();
            this.storySummary=""

            
        }
    }