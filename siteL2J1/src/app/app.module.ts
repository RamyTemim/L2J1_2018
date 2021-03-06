import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import {HttpClientModule} from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

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
import { SudokuFacileComponent } from './sudoku-facile/sudoku-facile.component';
import { SudokuNormalComponent } from './sudoku-normal/sudoku-normal.component';
import { SudokuDifficileComponent } from './sudoku-difficile/sudoku-difficile.component';
import { SudokuIndexComponent } from './sudoku-index/sudoku-index.component';
import { MorpionIndexComponent } from './morpion-index/morpion-index.component';
import { MorpionGrilleComponent } from './morpion-grille/morpion-grille.component';
import { MorpionJ1vsIaComponent } from './morpion-j1vs-ia/morpion-j1vs-ia.component';
import { MorpionJ1vsJ2Component } from './morpion-j1vs-j2/morpion-j1vs-j2.component';
import { JoueurComponent } from './joueur/joueur.component';
import { FormsModule } from '@angular/forms';
import { SudokuSolutionComponent } from './sudoku-solution/sudoku-solution.component';
import { PfcComponent } from './pfc/pfc.component';
import { PfcIndexComponent } from './pfc-index/pfc-index.component';

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
    ConditionComponent,
    SudokuFacileComponent,
    SudokuNormalComponent,
    SudokuDifficileComponent,
    SudokuIndexComponent,
    MorpionIndexComponent,
    MorpionGrilleComponent,
    MorpionJ1vsIaComponent,
    MorpionJ1vsJ2Component,
    JoueurComponent,
    SudokuSolutionComponent,
    PfcComponent,
    PfcIndexComponent
  ],
  imports: [
    BrowserModule,
	ReactiveFormsModule,
    AppRoutingModule,
	HttpClientModule,
    HttpModule,
    FormsModule
  ],
  providers: [SudokuService],
  bootstrap: [AppComponent]
})
export class AppModule { }
