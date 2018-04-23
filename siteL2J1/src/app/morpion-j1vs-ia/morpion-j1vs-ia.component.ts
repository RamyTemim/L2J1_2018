import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-morpion-j1vs-ia',
  templateUrl: './morpion-j1vs-ia.component.html',
  styleUrls: ['./morpion-j1vs-ia.component.css']
})
export class MorpionJ1vsIaComponent implements OnInit {
  grille: string[] = [" "," "," "," "," "," "," "," "," "];
  tour: any;
  gameStatus: number;
  libre: boolean = false;
  IA: any;

  constructor(private httpClient: HttpClient) {
    this.getTour();
    this.reset();
  }

  ngOnInit() {
  }

  //Change le tour à chaque coup

  changeTour() {
    if (this.tour == 1){
      this.tour = 2;
    }
    else {
      this.tour = 1;
    }
  }

  //Event à chaque clique d'une case -> envoie un post contenant l'id de la case

    onClick(i: number){
      console.log("Vous avez cliqué sur la case: " +i);

      if (this.grille[i]==" "){
        this.libre = true;
      }
      else {
        this.libre = false;
      }

      if (this.libre==false){
        return;
      }

        if (this.tour==1){
          this.grille[i] = "X";
          this.getGameStatus();
          this.changeTour();

        }

        this.httpClient
        .post("http://localhost:8080/morpion/move", { 'idcase': i })
        .subscribe(
          (response) => {
            console.log("C'est envoyé!");
          },
          (error) => {
            console.log("Erreur: "+error);
          }
        )

        if (this.tour==2){
          this.getIAMove();
          this.grille[this.IA] = "O";
          this.getGameStatus();
          this.changeTour();
        }
      }

    getIAMove(){
        this.httpClient
        .get<any[]>("http://localhost:8080/morpion/automove")
        .subscribe(
          (response) => {
            this.IA = response;
            console.log(this.IA);
          },
          (error) => {
            console.log("Erreur : "+error);
          }
        )
      }

  //Donne l'état du jeu

  getGameStatus(){
    this.httpClient
    .get("http://localhost:8080/morpion/gamestatus")
    .subscribe(resultat => {
        if (resultat==4){
            console.log("Partie en cours");
        }
        if (resultat==1){
            alert("Joueur 1 a gagné !");
            this.reset();
            this.tour = 1;
        }
        if (resultat==2){
            alert("Joueur 2 a gagné !");
            this.reset();
            this.tour = 1;
        }
        if (resultat==3){
            alert("Match nul");
            this.reset();
            this.tour = 1;
        }
    });
  }

  //Donne le tour

    getTour(){
      this.httpClient
      .get<any[]>("http://localhost:8080/morpion/player")
      .subscribe(
        (response) => {
          this.tour = response;
        },
        (error) => {
          console.log("Erreur : "+error);
        }
      )
    }

  //Reset la grille back et front

    reset(){
      this.httpClient
      .post("http://localhost:8080/morpion/reset", 1)
      .subscribe(
        (response) => {
          console.log("Reset envoyé !");
        },
        (error) => {
          console.log("Erreur: "+error);
        }
      )
      var newGrille: string[] = [" "," "," "," "," "," "," "," "," "];
      this.grille = newGrille;
      this.libre = false;
      this.tour = 1;
  }

  }
