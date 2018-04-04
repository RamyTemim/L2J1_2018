import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { catchError, retry } from 'rxjs/operators';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-morpion-j1vs-ia',
  templateUrl: './morpion-j1vs-ia.component.html',
  styleUrls: ['./morpion-j1vs-ia.component.css']
})
export class MorpionJ1vsIaComponent implements OnInit {
  /*private createURL : 'http://localhost:8080/morpion/create'; // post
  private listURL : 'http://localhost:8080/morpion/list'; // get
  private autocreateURL : 'http://localhost:8080/morpion/autocreate'; // get
  private checkURL : 'http://localhost:8080/morpion/check'; // get
  private turnURL : 'http://localhost:8080/morpion/turn'; //get
  listMove:  any ={};
  move: any = {};
  listPosition: any={};
  turn : boolean;

  constructor(private http :Http) {
    this.getListMove();
    this.getMove();
    this.getListPosition();
    this.getTurn();
  }

*/
  ngOnInit() {

  }
/*
  getListMoveData(){
    return this.http.get(this.listURL)
    .map((res: Response) => res.json())
  }
  getListMove(){
      console.log('Affichage de la listMove');
    this.getListMoveData().subscribe(listMove =>{
      console.log(listMove);
      this.listMove = listMove
    })
  }

  getMoveData(){
    return this.http.get(this.autocreateURL)
    .map((res: Response) => res.json())
  }
  getMove(){
      console.log('Affichage de Move');
    this.getMoveData().subscribe(move =>{
      console.log(move);
      this.move = move
    })
  }

  getListPositionData(){
    return this.http.get(this.checkURL)
    .map((res: Response) => res.json())
  }
  getListPosition(){
      console.log('Affichage de la listPosition');
    this.getListPositionData().subscribe(listPosition =>{
      console.log(listPosition);
      this.listPosition = listPosition
    })
  }

  getTurnData(){
    return this.http.get(this.turnURL)
    .map((res: Response) => res.json())
  }
  getTurn(){
      console.log('Affichage du turn');
    this.getTurnData().subscribe(turn =>{
      console.log(turn);
      this.turn = turn
    })
  }
*/
}
