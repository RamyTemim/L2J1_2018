import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-sudoku-normal',
  templateUrl: './sudoku-normal.component.html',
  styleUrls: ['./sudoku-normal.component.css']
})
export class SudokuNormalComponent implements OnInit {
  private sudokuNormalUrl = 'http://localhost:8080/sudokuNormal';
  private solution = 'http://localhost:8080/solvedSudoku';
  data2: any ={};
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
      console.log('Affichage grille normal');
    this.getDataNormal().subscribe(data2 =>{
      console.log(data2);
      this.data2 = data2
    })
  }
     getGrilleSolved(){
      console.log('Affichage de la solution');
    this.getDataSolution().subscribe(data2sol =>{
      console.log(data2sol);
      this.data2sol = data2sol
    })
  }


  ngOnInit() {
  }

}
