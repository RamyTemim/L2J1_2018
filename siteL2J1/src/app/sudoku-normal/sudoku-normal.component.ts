import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-sudoku-normal',
  templateUrl: './sudoku-normal.component.html',
  styleUrls: ['./sudoku-normal.component.css']
})
export class SudokuNormalComponent implements OnInit {
  private sudokuNormalUrl = 'http://localhost:8080/sudoku/sudokuNormal';
  data2: number[][];

  constructor(private http: Http) {
  this.getGrilleNormal();
  }

  getDataNormal(){
    return this.http.get(this.sudokuNormalUrl)
    .map((res: Response) => res.json())
  }
  
  
  getGrilleNormal(){
    this.getDataNormal().subscribe(data2 =>{
      this.data2 = data2
    })
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
