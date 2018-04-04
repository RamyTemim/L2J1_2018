package morpion;



public class GameService {
	 public Game createNewGame( GameUSer gameuser ) {
		 
		  // gameuser a les choit de l utilisateur a propos de morpion 
		 Game game = new Game()  ;
		 Player joueur1;
		 Player joueur2;
		 game.setId(gameuser.getGameType());
		 game.setFirstPlayerPiece(gameuser.getPiece());
		 if (gameuser.getGameType()== "COMPUTER") {
			  joueur1 = new Player("COMPUTER ", gameuser.getPiece());
			  
			  if (gameuser.getPiece() == "O")
			  joueur2 = new Player("humain","X");
			  else 
			  joueur2 = new Player("humain","O");
				  
		 }else {
			  joueur1 = new Player("humain1 ", gameuser.getPiece());
			  if (gameuser.getPiece() == "O")
				  joueur2 = new Player("humain2", "X");
				  else 
				  joueur2 = new Player("humain2","O");
		 }
			 game.setFirstPlayer(joueur1);
			 game.setSecondPlayer(joueur2);
			 game.setFirstPlayerPiece(joueur1.getPiece());
			 
		 return game;
	 }

	    public Game updateGameStatus(Game game, String gameStatus) {
	       
	        game.setStatus(gameStatus);

	        return game;
	}
	
	   
	
	   
}
