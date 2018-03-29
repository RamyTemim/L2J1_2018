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
  console.log(this.data2);
  //alert("you win !");
  console.log(myJsonString);
  this.http.post("http://localhost:4200/sudoku-facile/post", {"moo":"foo","goo":"loo"}).subscribe(res => console.log(res.json()), const headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded' }));
  //return myJsonString ;
  
  }

}
