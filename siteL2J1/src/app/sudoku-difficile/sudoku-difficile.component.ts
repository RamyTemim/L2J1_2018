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
  data1: number[][];
  data2: number[][];

  constructor(private http: Http) {
  this.getGrilleDifficile();
  }

  getDataDifficile(){
    return this.http.get(this.sudokuDifficileUrl)
    .map((res: Response) => res.json())
  }

  getGrilleDifficile(){
    this.getDataDifficile().subscribe(dataTmp =>{
      this.data1 = dataTmp;
	  this.data2 = this.data1.map(function(arr) {
    return arr.slice();
});
    });
  }

  ngOnInit() {
  }
  
    saveNumber(x,i,j) {
  var y = +x;
	this.data2[i][j] = y ;
  }
  
  validate(){
	var myJsonString = JSON.stringify(this.data2);

 this.http.post("http://localhost:8080/sudoku/result", {myJsonString}).subscribe(resultat => {
 if(resultat.json())
	{alert("you win !");}
  else
	{alert("you lose");}
  
 });
  
  }

}
