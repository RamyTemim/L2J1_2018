import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-sudoku-normal',
  templateUrl: './sudoku-normal.component.html',
  styleUrls: ['./sudoku-normal.component.css']
})
export class SudokuNormalComponent implements OnInit {
  private sudokuNormalUrl = 'http://localhost:8080/sudoku/sudokuNormal';
  private solution = 'http://localhost:8080/sudoku/solvedSudoku';
  data2: number[][];
  data2sol: any ={};

  constructor(private http: Http) {
  this.getGrilleNormal();
  this.getGrilleSolved();
  }

  getDataNormal(){
    return this.http.get(this.sudokuNormalUrl)
    .map((res: Response) => res.json())
  }
  
   getDataSolution(){
    return this.http.get(this.solution)
    .map((res: Response) => res.json())
  }
  
  getGrilleNormal(){
    this.getDataNormal().subscribe(data2 =>{
      this.data2 = data2
    })
  }
     getGrilleSolved(){
    this.getDataSolution().subscribe(data2sol =>{
      this.data2sol = data2sol
    })
  }


  ngOnInit() {
  }

}
