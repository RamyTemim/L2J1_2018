import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
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
  constructor(public gameType: "COMPUTER", piece: "X") {}
}

class Choix2 {
  constructor(public gameType: "COMPETITION", piece: "X") {}
}

@Component({
  selector: 'app-morpion',
  templateUrl: './morpion.component.html',
  styleUrls: ['./morpion.component.css']
})
export class MorpionComponent implements OnInit {
private gameType = GameType;
private piece = Piece;
private choix1 = Choix1;
private choix2 = Choix2;

  constructor(private httpClient: HttpClient) {
   }

   postChoix1(){

     var myJsonString = (JSON.stringify(this.choix1));
     console.log(myJsonString);

         this.httpClient
         .post("http://localhost:8080/morpion/creategame", {myJsonString})
         .subscribe(
           () => {
             console.log("Choix envoyé : J1 vs IA");
           },
           (error) => {
             console.log ("Erreur : " + error);
           }
         );
    }

    postChoix2(){

      var myJsonString = JSON.stringify(this.choix2);

          this.httpClient
          .post("http://localhost:8080/morpion/creategame", {myJsonString})
          .subscribe(
            () => {
              console.log("Choix envoyé : J1 vs IA");
            },
            (error) => {
              console.log ("Erreur : " + error);
            }
          );
     }

  ngOnInit() {
  }

}
