import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import {HttpClientModule} from '@angular/common/http';
import { NovelComponent } from './novel/novel.component';
import { MagazineComponent } from './magazine/magazine.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NovelComponent,
    MagazineComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
