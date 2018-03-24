import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-sudoku-difficile',
  templateUrl: './sudoku-difficile.component.html',
  styleUrls: ['./sudoku-difficile.component.css']
})
export class SudokuDifficileComponent implements OnInit {
  private sudokuDifficileUrl = 'http://localhost:8080/sudoku/sudokuDifficile';
  data3: number[][];


  constructor(private http: Http) {
  this.getGrilleDifficile();
  }

  getDataDifficile(){
    return this.http.get(this.sudokuDifficileUrl)
    .map((res: Response) => res.json())
  }
  
  getGrilleDifficile(){
    this.getDataDifficile().subscribe(data3 =>{
      this.data3 = data3
    })
  }

  ngOnInit() {
  }

}
