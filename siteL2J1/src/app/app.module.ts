import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { IndexComponent } from './index/index.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SudokuComponent } from './sudoku/sudoku.component';
import { MorpionComponent } from './morpion/morpion.component';
import { AppRoutingModule } from './/app-routing.module';
import { AuteurComponent } from './auteur/auteur.component';
import { ContacterComponent } from './contacter/contacter.component';
import { ConditionComponent } from './condition/condition.component';
import { SudokuService } from './sudoku.service';


@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    HeaderComponent,
    FooterComponent,
    SudokuComponent,
    MorpionComponent,
    AuteurComponent,
    ContacterComponent,
    ConditionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [SudokuService],
  bootstrap: [AppComponent]
})
export class AppModule { }
