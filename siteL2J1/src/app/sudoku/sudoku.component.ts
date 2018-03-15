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
  data: any ={};

  constructor(private http: Http) {
    console.log('Affichage grille facile');
    this.getGrilleFacile();
    console.log('Affichage grille normal');
    this.getGrilleNormal();
    console.log('Affichage grille difficile');
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
  this.getDataFacile().subscribe(data =>{
    console.log(data);
    this.data = data
  })
}

getGrilleNormal(){
  this.getDataNormal().subscribe(data =>{
    console.log(data);
    this.data = data
  })
}

getGrilleDifficle(){
  this.getDataDifficile().subscribe(data =>{
    console.log(data);
    this.data = data
  })
}
  ngOnInit() {
  }

}
