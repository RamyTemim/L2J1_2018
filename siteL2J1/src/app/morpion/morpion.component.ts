import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { catchError, retry } from 'rxjs/operators';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

enum GameType {
  COMPUTER,
  COMPETITION
}

 enum Piece {
  X,
  O
}

class Choix1 {
  constructor(public gameType: 0, piece: 0) {}
}

class Choix2 {
  constructor(public gameType: 1, piece: 0) {}
}

@Component({
  selector: 'app-morpion',
  templateUrl: './morpion.component.html',
  styleUrls: ['./morpion.component.css']
})
export class MorpionComponent implements OnInit {
private gameType = GameType;
private piece = Piece;
private choix1: Choix1;
private choix2: Choix2;
private CreateUrl = 'http://localhost:8080/morpion/create';

  constructor(private http: Http) {
    this.postChoix1();
    this.postChoix2();
   }

   postChoix1(){
         this.http.post(this.CreateUrl, this.choix1).subscribe(res => console.log(res.json()));
         console.log("Choix envoyé");
   }

   postChoix2(){
         this.http.post(this.CreateUrl, this.choix2).subscribe(res => console.log(res.json()));
         console.log("Choix envoyé");
   }

  ngOnInit() {
  }

}
