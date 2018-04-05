import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-morpion-grille',
  templateUrl: './morpion-grille.component.html',
  styleUrls: ['./morpion-grille.component.css']
})
export class MorpionGrilleComponent implements OnInit {
  cases: number[] = [0,0,0];

  constructor() { }
  //Fonction 1
  function verifCaseLibre(boardRow, boardColumn) {

      for (var i=0; i < scope.movesInGame.length; i++) {
          var move = scope.movesInGame[i];
          if(move.boardColumn == boardColumn && move.boardRow == boardRow) {
              return false;
          }
      }
      return true;
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
   checkPlayerTurn().success(function () {

       var boardRow = parseInt(column.id.charAt(0));
       var boardColumn = parseInt(column.id.charAt(1));
       var params = {'boardRow': boardRow, 'boardColumn': boardColumn}

       if (checkIfBoardCellAvailable(boardRow, boardColumn) == true) {
           // if player has a turn
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

  onClick(){
    console.log("test des conditions");
  }

  ngOnInit() {
  }

}
