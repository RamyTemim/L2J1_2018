import { Component, OnInit } from '@angular/core';
import { SudokuService } from '../sudoku.service';

@Component({
  selector: 'app-sudoku',
  templateUrl: './sudoku.component.html',
  styleUrls: ['./sudoku.component.css']
})
export class SudokuComponent implements OnInit {
  sudoku: Array<any>;

  constructor(private sudokuService: SudokuService) { }

  ngOnInit() {
    this.sudokuService.getAll().subscribe(
      data => {
        this.sudoku = data;
      },
      error => console.log(error)
    )
  }

}
