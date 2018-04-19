import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-morpion-grille',
  templateUrl: './morpion-grille.component.html',
  styleUrls: ['./morpion-grille.component.css'],
})
export class MorpionGrilleComponent implements OnInit {

grille: string[] = [" "," "," "," "," "," "," "," "];
tour: any;
gameStatus: number;

constructor(private httpClient: HttpClient) {
  this.getTour();
}

// caseToGrille(){
//   this.grille = [];
//     for (var i=0; i<9; i++) {
//       var case = new Case();
//       case.id = i;
//       case.contenu = "";
//       this.grille.push(this.case);
//   }
// }

ngOnInit() {
}

changeTour() {
  if (this.tour == 1){
    this.tour = 2;
  }
  else {
    this.tour = 1;
  }
}

  onClick(i: number){
    console.log("Vous avez cliqué sur la case: " +i);
    // var myJsonString = JSON.stringify(i);
    // console.log(myJsonString);

    if (this.tour==1){
      this.grille[i] = "X";
    }
    if (this.tour==2){
      this.grille[i] = "O";
    }

    this.changeTour();


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

    this.getGameStatus();
  }

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
      }
  });
}

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
    var newGrille: string[] = [" "," "," "," "," "," "," "," "];
    this.grille = newGrille;
}

}


  // Fonction pour le morpion
  //Fonction 1 Le code n'est pas complet
  //La fonction 1 doit verifier si la case est libre et retourne un booleen

  // verifCaseLibre() {
  //    var libre = true;
  //
  //    for (var i=0 ; i < 3; i++) {
  //     for (var j=0; j < 3; j++) {
  //        if(this.cases[i][j] == 'X' || this.cases[i][j] == 'O') {
  //            console.log("Cette case est occupée");
  //            console.log(this.cases[i][j]);
  //            libre = false;
  //            return libre;
  //        }
  //      }
  //    }
  //    console.log("Cette case est vide");
  //    libre = true;
  //    return libre;
  //  }

   // verifCaseLibre() {
   //    var libre = true;
   //
   //    for (var i=0 ; i < this.cases1.length; i++) {
   //        if(this.cases1[i].piece == 'X' || this.cases1[i].piece == 'O') {
   //            console.log("Cette case est occupée");
   //            console.log(this.cases1[i].piece);
   //            libre = false;
   //            return libre;
   //        }
   //    }
   //    console.log("Cette case est vide");
   //    libre = true;
   //    return libre;
   //  }

//Fonction 2 : Vérifie le tour du joueur
/*
//Pas encore testé
verifTourJoueur() {

   this.httpClient
   .get<any[]>('http://localhost8080/morpion/turn')
   .subscribe(
    (response) => {
      this.dataTurn = response;
      console.log(this.dataTurn);
    },
    (error) => {
      console.log("Erreur ! :"+error);
    }
    );
    if (this.dataTurn==this.turn) {
      return true;
    }
    else return false;
}
/*
//Fonction 3
markPlayerMove = (cases1) {
   if (verifTourJoueur() == true) {

       var ligne = parseInt(cases1.id.charAt(0));
       var colonne = parseInt(cases1.id.charAt(1));
       var params = {'boardRow': boardRow, 'boardColumn': boardColumn}

       if (verifCaseLibre(id) == true) {
           // si c'est le tour du joueur
           if (playerTurn == true) {

               HttpClient
               .post("http://localhost8080/morpion/create")
               .subscribe(
                (response) => {
                console.log("terminé");
                },
                (error) => {
                console.log("Erreur : "+error);
              }

               );
                   getMoveHistory().success(function () {
                       var gameStatus = scope.movesInGame[scope.movesInGame.length - 1].gameStatus;
                       if (gameStatus == 'IN_PROGRESS') {
                           getNextMove();
                       } else {
                           alert(gameStatus)
                       }
                   });

               }).error(function (data, status, headers, config) {
                   scope.errorMessage = "Can't send the move"
               });

           }
       }
   });
};

//Fonction 4
function getNextMove() {
scope.nextMoveData = []
 http.get("/move/autocreate").success(function (data, status, headers, config) {
     scope.nextMoveData = data;
     getMoveHistory().success(function () {
         var gameStatus = scope.movesInGame[scope.movesInGame.length - 1].gameStatus;
         if (gameStatus != 'IN_PROGRESS') {
             alert(gameStatus)
         }
     });
 }).error(function (data, status, headers, config) {
     scope.errorMessage = "Can't send the move"
 });
}
*/
/*
setValue(cases1){
  this.cases1 = cases1;
  for (var i=0; i<3; i++){
    if ( this.cases1.piece[i] == "tick") {
      this.cases1.value[i] = "done";
    }
    else {
      this.cases1.value[i] = "close";
    }
  }
} */
