import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-sudoku-solution',
  templateUrl: './sudoku-solution.component.html',
  styleUrls: ['./sudoku-solution.component.css']
})

export class SudokuSolutionComponent implements OnInit {
private solution = 'http://localhost:8080/sudoku/solvedSudoku';
datasol: number[][];

  constructor(private http: Http) {
    this.getGrilleSolved();
  }

  getDataSolution(){
   return this.http.get(this.solution)
   .map((res: Response) => res.json())
 }

    getGrilleSolved(){
   this.getDataSolution().subscribe(datasol =>{
     this.datasol = datasol
   })
 }

  ngOnInit() {
  }

}
