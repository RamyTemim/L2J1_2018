import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-sudoku',
  templateUrl: './sudoku.component.html',
  styleUrls: ['./sudoku.component.css']
})
export class SudokuComponent implements OnInit {
  case: number[] = [0,0,0,0,0,0,0,0,0];
  row: number[] = [0,0,0,0,0,0,0];

  ngOnInit() {
  }

}
