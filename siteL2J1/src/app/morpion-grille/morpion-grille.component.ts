import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-morpion-grille',
  templateUrl: './morpion-grille.component.html',
  styleUrls: ['./morpion-grille.component.css']
})
export class MorpionGrilleComponent implements OnInit {
  /*
  cases: number[] = [0,0,0];
  */
  //*********** Chaque cases contiennent un id et la valeur de la piece ***********
  cases1 = [
    {
      id:11,
      piece:"O"
    },
    {
      id:12,
      piece:"O"
    },
    {
      id:13,
      piece:"O"
    }
  ];
  cases2 = [
    {
      id:21,
      piece:""
    },
    {
      id:22,
      piece:""
    },
    {
      id:23,
      piece:""
    }
  ];
  cases3 = [
    {
      id:31,
      piece:""
    },
    {
      id:32,
      piece:""
    },
    {
      id:33,
      piece:""
    }
  ];
  constructor() { }

  /* Fonction pour le morpion
  //Fonction 1 Le code n'est pas complet
  //La fonction 1 doit verifier si la case est libre et retourne un booleen

  function verifCaseLibre(id) {
      var cases1 =['','',''];
      for (var i=0 ; i < cases1.length; i++) {
          var move = cases[i];
          if(cases1[i] == 'X' || cases1[i] == 'O') {
              return false;
          }
      }
      return true;
      console.log(verifCaseLibre(id));
    }

//Fonction 2

function verifTourJoueur() {

   http.get('/move/turn').success(function(data) {
       scope.playerTurn = data;
   }).error(function(data, status, headers, config) {
       scope.errorMessage = "Failed to get the player turn"
   });
}

//Fonction 3
scope.markPlayerMove = function (column) {
   verifTourJoueur().success(function () {

       var ligne = parseInt(column.id.charAt(0));
       var colonne = parseInt(column.id.charAt(1));
       var params = {'boardRow': boardRow, 'boardColumn': boardColumn}

       if (verifCaseLibre(id) == true) {
           // si c'est le tour du joueur
           if (scope.playerTurn == true) {

               http.post("/move/create", params, {
                   headers: {
                       'Content-Type': 'application/json; charset=UTF-8'
                   }
               }).success(function () {
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

  onClick(){
    console.log("test des conditions");
  }

  ngOnInit() {
  }

}
