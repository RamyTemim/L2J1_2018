import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sudoku-index',
  templateUrl: './sudoku-index.component.html',
  styleUrls: ['./sudoku-index.component.css']
})
export class SudokuIndexComponent implements OnInit {
  case: number[] = [0,0,0,0,0,0,0,0,0];
  row: number[] = [0,0,0,0,0,0,0,0];
  constructor() { }

  ngOnInit() {
  }

}
