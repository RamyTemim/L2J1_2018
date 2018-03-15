import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-sudoku-facile',
  templateUrl: './sudoku-facile.component.html',
  styleUrls: ['./sudoku-facile.component.css']
})
export class SudokuFacileComponent implements OnInit {
  private sudokuFacileUrl = 'http://localhost:8080/sudokuFacile';
  data1: any ={};

  constructor(private http: Http) {
  this.getGrilleFacile();
  }

  getDataFacile(){
    return this.http.get(this.sudokuFacileUrl)
    .map((res: Response) => res.json())
  }
  getGrilleFacile(){
      console.log('Affichage grille facile');
    this.getDataFacile().subscribe(data1 =>{
      console.log(data1);
      this.data1 = data1
    })
  }

  ngOnInit() {
  }

}
