import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-sudoku',
  templateUrl: './sudoku.component.html',
  styleUrls: ['./sudoku.component.css']
})
export class SudokuComponent implements OnInit {
  private sudokuFacileUrl = 'http://localhost:8080/sudokuFacile'; 
  private sudokuNormalUrl = 'http://localhost:8080/sudokuNormal';
  private sudokuDifficileUrl = 'http://localhost:8080/sudokuDifficile';
  data1: any ={};
  data2: any ={};
  data3: any ={};

  constructor(private http: Http) {
    this.getGrilleFacile();
    this.getGrilleNormal();
    this.getGrilleDifficle();
   }

/*On récupère les data en json*/

getDataFacile(){
  return this.http.get(this.sudokuFacileUrl)
  .map((res: Response) => res.json())
}

getDataNormal(){
  return this.http.get(this.sudokuNormalUrl)
  .map((res: Response) => res.json())
}

getDataDifficile(){
  return this.http.get(this.sudokuDifficileUrl)
  .map((res: Response) => res.json())
}

getGrilleFacile(){
    console.log('Affichage grille facile');
  this.getDataFacile().subscribe(data1 =>{
    console.log(data1);
    this.data1 = data1
  })
}

getGrilleNormal(){
	console.log('Affichage grille normal');
  this.getDataNormal().subscribe(data2 =>{
    console.log(data2);
    this.data2 = data2
  })
}

getGrilleDifficle(){
    console.log('Affichage grille difficile');
  this.getDataDifficile().subscribe(data3 =>{
    console.log(data3);
    this.data3 = data3
  })
}
  ngOnInit() {
  }

}
