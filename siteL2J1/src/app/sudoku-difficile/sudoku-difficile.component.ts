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
  
    saveNumber(x,i,j) {
  var y = +x;
	this.data3[i][j] = y ;
  }
  
  validate(){
	var myJsonString = JSON.stringify(this.data3);
  console.log(this.data3);
  //alert("you win !");
  console.log(myJsonString);
  this.http.post("http://localhost:4200/sudoku-facile/post", {"moo":"foo","goo":"loo"}).subscribe(res => console.log(res.json()), const headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded' }));
  //return myJsonString ;
  
  }

}
