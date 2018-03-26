package Service;


import Details.Game;
import Details.Player;
import Enumeration.GameStatus;
import Enumeration.GameType;
import Enumeration.Piece;
import UserOpt.GameUSer;

public class GameService {
	 public Game createNewGame( GameUSer gameuser ) {
		 
		  // gameuser a les choit de l utilisateur a propos de morpion 
		 Game game = new Game()  ;
		 Player joueur1;
		 Player joueur2;
		 game.setId(gameuser.getGameType());
		 game.setFirstPlayerPiece(gameuser.getPiece());
		 if (gameuser.getGameType()== GameType.COMPUTER) {
			  joueur1 = new Player("COMPUTER ", gameuser.getPiece());
			  
			  if (gameuser.getPiece() == Piece.O)
			  joueur2 = new Player("humain",Piece.X);
			  else 
			  joueur2 = new Player("humain",Piece.O);
				  
		 }else {
			  joueur1 = new Player("humain1 ", gameuser.getPiece());
			  if (gameuser.getPiece() == Piece.O)
				  joueur2 = new Player("humain2",Piece.X);
				  else 
				  joueur2 = new Player("humain2",Piece.O);
		 }
			 game.setFirstPlayer(joueur1);
			 game.setSecondPlayer(joueur2);
			 game.setFirstPlayerPiece(joueur1.getPiece());
			 
		 return game;
	 }

	    public Game updateGameStatus(Game game, GameStatus gameStatus) {
	       
	        game.setStatus(gameStatus);

	        return game;
	}
	
	   
	
	   
}
