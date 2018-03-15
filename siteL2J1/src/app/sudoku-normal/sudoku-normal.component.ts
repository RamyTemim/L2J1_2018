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
  data2: any ={};

  constructor(private http: Http) {
  this.getGrilleNormal();
  }

  getDataNormal(){
    return this.http.get(this.sudokuNormalUrl)
    .map((res: Response) => res.json())
  }
  getGrilleNormal(){
      console.log('Affichage grille normal');
    this.getDataNormal().subscribe(data2 =>{
      console.log(data2);
      this.data2 = data2
    })
  }


  ngOnInit() {
  }

}
