import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  ngOnInit(){
    this.isActiveNovel=true;
  }

isActiveNovel:boolean=false;
isActiveMagazine:boolean=false;

  @Output()
  activeTabChanged : EventEmitter<string>= new EventEmitter<string>();

  setNovelsActive(){
    this.activeTabChanged.emit("novels");
    this.isActiveNovel=true;
    this.isActiveMagazine=false;
  }

  setMagazinesActive(){
    this.activeTabChanged.emit("magazines");
    this.isActiveMagazine=true;
    this.isActiveNovel=false;
}
}
