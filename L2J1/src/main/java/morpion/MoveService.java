package morpion;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import morpion.Game;

@Service 
public class MoveService {
	public Move createMove(Game game ,Player player , Moveuser createMove) {
       Move move= new Move();
       Position pos = new Position();
       pos.setBoardCel(move.getCollonne());
       pos.setBoardRow(move.getLigne());
       pos.setId(player.getId());
       
       move.setCollonne(createMove.getBoardCel());
       move.setLigne(createMove.getBoardRow());
       move.setPlayer(player);
       game.setDeplacements(move);
       game.setPlayerPosition(pos);
        return move;
	}
	
	//////// les deplacement effectuer dans le jeu pour 
	///////   verifier si le prochaine deplacement est valide ou pas
	
	  public List<Move> getMovesInGame(Game game ) {
	        return game.getDeplacements();
	}
	  ///////// nous retourne le nombre de fois de move de joueur s
	  public int getTheNumberOfPlayerMovesInGame( Game game, Player player) {
			int nb = 0  ;
			List<List<Position>> allposition = new ArrayList<>();
			
			 for (int i = 0; i < allposition.size();i++) {
				if ((allposition.get(i)).get(2).getId() == player.getId()){
					nb = nb +1 ;
				}
					
			}
			
		    return nb ;
		}
	  
	  ///////
	  //////  les postion prise dans le jeu 
	 //////
	   public List<Position> getTakenMovePositionsInGame(Game game) {
	        return game.getDeplacements().stream()
	                .map(move -> new Position(move.getLigne(), move.getCollonne()))
	                .collect(Collectors.toList());
	}
	   
	   
	    public List<Position> getPlayerMovePositionsInGame(Game game, Player player) {

	        return game.getPlayerPosition().stream()
	                .map(move -> new Position(move.getBoardRow(), move.getBoardCel()))
	                .collect(Collectors.toList());
	}
	  
	    public GameStatus checkCurrentGameStatus(Game game) {
	        if (GameLogic.isWinner(getPlayerMovePositionsInGame(game, game.getFirstPlayer()))) {
	            return GameStatus.FISRT_PLAYER_WON;
	        } else if (GameLogic.isWinner(getPlayerMovePositionsInGame(game, game.getSecondPlayer()))) {
	            return GameStatus.SECOND_PLAYER_WON;
	        } else if (GameLogic.isBoardisFull(getTakenMovePositionsInGame(game))) {
	            return GameStatus.TIE;
	        } else {
	            return GameStatus.IN_PROGRESS;
	        }

	}
	  
	   //////
	  ////// l intelegence artificiel 
	 //////
	  public Move autoCreateMove(Game game) {
		   Move move = new Move();
		   move.setCollonne(GameLogic.nextMoveIA(game.getDeplacements(),5,game).getBoardCel());
		   move.setLigne(GameLogic.nextMoveIA(game.getDeplacements(),5,game).getBoardRow());
		   move.setPlayer(null);
		   game.setDeplacements(move);
		 
		   return move;
	  }
	  
	    public boolean isPlayerTurn(Game game, Player firstPlayer, Player secondPlayer) {
	        return GameLogic.playerTurn(getTheNumberOfPlayerMovesInGame(game, firstPlayer),
	        		getTheNumberOfPlayerMovesInGame(game, secondPlayer));
	}
	    
	}
	

	
	  
    


