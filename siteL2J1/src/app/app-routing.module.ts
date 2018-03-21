import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { IndexComponent }       from './index/index.component';
import { SudokuComponent }      from './sudoku/sudoku.component';
import { MorpionComponent }     from './morpion/morpion.component';
import { AuteurComponent }     from './auteur/auteur.component';
import { ConditionComponent }     from './condition/condition.component';
import { ContacterComponent }     from './contacter/contacter.component';
import { SudokuFacileComponent }  from './sudoku-facile/sudoku-facile.component';
import { SudokuNormalComponent }  from './sudoku-normal/sudoku-normal.component';
import { SudokuDifficileComponent }  from './sudoku-difficile/sudoku-difficile.component';
import { SudokuIndexComponent } from './sudoku-index/sudoku-index.component';
import { MorpionIndexComponent }     from './morpion-index/morpion-index.component';
import { MorpionJ1vsIaComponent } from './morpion-j1vs-ia/morpion-j1vs-ia.component';
import { MorpionJ1vsJ2Component } from './morpion-j1vs-j2/morpion-j1vs-j2.component';
import { SudokuSolutionComponent } from './sudoku-solution/sudoku-solution.component';

const routes: Routes = [
  { path: '', redirectTo: '/index', pathMatch: 'full' },
  { path: 'index', component: IndexComponent },
  { path: 'sudoku', component: SudokuComponent },
  { path: 'morpion', component: MorpionComponent },
  { path: 'auteur', component: AuteurComponent },
  { path: 'condition', component: ConditionComponent },
  { path: 'contacter', component: ContacterComponent },
  { path: 'sudoku-facile', component: SudokuFacileComponent},
  { path: 'sudoku-normal', component: SudokuNormalComponent},
  { path: 'sudoku-difficile', component: SudokuDifficileComponent},
  { path: 'sudoku-index', component: SudokuIndexComponent},
  { path: 'morpion-index', component: MorpionIndexComponent },
  { path: 'morpion-j1vs-ia', component: MorpionJ1vsIaComponent },
  { path: 'morpion-j1vs-j2', component: MorpionJ1vsJ2Component },
  { path: 'sudoku-solution', component: SudokuSolutionComponent }

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
