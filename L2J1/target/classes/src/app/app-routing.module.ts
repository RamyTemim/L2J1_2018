import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { IndexComponent }       from './index/index.component';
import { SudokuComponent }      from './sudoku/sudoku.component';
import { MorpionComponent }     from './morpion/morpion.component';
import { AuteurComponent }     from './auteur/auteur.component';
import { ConditionComponent }     from './condition/condition.component';
import { ContacterComponent }     from './contacter/contacter.component';

const routes: Routes = [
  { path: '', redirectTo: '/index', pathMatch: 'full' },
  { path: 'index', component: IndexComponent },
  { path: 'sudoku', component: SudokuComponent },
  { path: 'morpion', component: MorpionComponent },
  { path: 'auteur', component: AuteurComponent },
  { path: 'condition', component: ConditionComponent },
  { path: 'contacter', component: ContacterComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
