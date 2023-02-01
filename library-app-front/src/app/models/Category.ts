import { CategoryType } from "./enums/CategoryType";

export class Category{
    id?:number;
    categoryType?:CategoryType;

    constructor(){
        this.id=0;
        this.categoryType=CategoryType.DEFAULT;
    }
}