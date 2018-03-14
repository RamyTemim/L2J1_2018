import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-sudoku',
  templateUrl: './sudoku.component.html',
  styleUrls: ['./sudoku.component.css']
})
export class SudokuComponent implements OnInit {
  private apiUrl = 'http://localhost:8080/sudokuFacile'; //Lien du sudokuFacile
  data: any ={};

  constructor(private http: Http) {
    console.log('Affichage grille facile');
    this.getGrille();
   }

/*On récupère les data en json*/

getData(){
  return this.http.get(this.apiUrl)
  .map((res: Response) => res.json())
}

getGrille(){
  this.getData().subscribe(data =>{
    console.log(data);
    this.data = data
  })
}
  ngOnInit() {
  }

}
