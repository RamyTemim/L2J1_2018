import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-sudoku-facile',
  templateUrl: './sudoku-facile.component.html',
  styleUrls: ['./sudoku-facile.component.css']
})
export class SudokuFacileComponent implements OnInit {
  private sudokuFacileUrl = 'http://localhost:8080/sudoku/sudokuFacile';
  private solution = 'http://localhost:8080/sudoku/solvedSudoku';
  data1:  number[][];
  data1sol: any ={};

  constructor(private http: Http) {
  this.getGrilleFacile();
  this.getGrilleSolved();
 
  }

  getDataFacile(){
    return this.http.get(this.sudokuFacileUrl)
    .map((res: Response) => res.json())
  }
  
  getDataSolution(){
    return this.http.get(this.solution)
    .map((res: Response) => res.json())
  }
  getGrilleFacile(){
      console.log('Affichage grille facile');
    this.getDataFacile().subscribe(data1 =>{
      console.log(data1);
      this.data1 = data1
    })
  }
   getGrilleSolved(){
      console.log('Affichage de la solution');
    this.getDataSolution().subscribe(data1sol =>{
      console.log(data1sol);
      this.data1sol = data1sol
    })
  }

  ngOnInit() {
  }

}
