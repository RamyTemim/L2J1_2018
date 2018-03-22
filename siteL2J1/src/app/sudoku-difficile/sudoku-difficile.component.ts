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
  private solution = 'http://localhost:8080/sudoku/solvedSudoku';
  data3: number[][];
  data3sol: any ={};


  constructor(private http: Http) {
  this.getGrilleDifficile();
   this.getGrilleSolved();
  }

  getDataDifficile(){
    return this.http.get(this.sudokuDifficileUrl)
    .map((res: Response) => res.json())
  }
     getDataSolution(){
    return this.http.get(this.solution)
    .map((res: Response) => res.json())
  }
  
  getGrilleDifficile(){
    this.getDataDifficile().subscribe(data3 =>{
      this.data3 = data3
    })
  }
       getGrilleSolved(){
    this.getDataSolution().subscribe(data3sol =>{
      this.data3sol = data3sol
    })
  }

  ngOnInit() {
  }

}
