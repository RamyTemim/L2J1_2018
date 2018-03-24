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
  data1:  number[][];

  constructor(private http: Http) {
  this.getGrilleFacile();
  }

  getDataFacile(){
    return this.http.get(this.sudokuFacileUrl)
    .map((res: Response) => res.json())
  }
  
  getGrilleFacile(){
    this.getDataFacile().subscribe(data1 =>{
      this.data1 = data1
    })
  }
  

  ngOnInit() {
  }
  

}
