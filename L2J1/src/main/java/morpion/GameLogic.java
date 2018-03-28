package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import Details.Game;
import Details.Move;
import Details.Player;
import Details.Position;
import Details.Series;
import Enumeration.GameStatus;
import Enumeration.GameType;
import Enumeration.Piece;

import static java.util.Arrays.asList;

public class GameLogic {
private final  Game game;
public GameLogic(Game game){
	this.game = game;
}
@Autowired
static 
MoveService moveservice;
 static int MINVAL =-1000;
 static int MAXVAL = 1000;
/**
 * Checks if the player wins
 * @param positions Board positions from player moves retrieved from database
 * @return true or false if the player is a winner
 */
static boolean isWinner(List<Position> positions) {

    return getWinnngPositions().stream().anyMatch(positions::containsAll);
}

///
/// retourner les position de winning 
// 

static List<List<Position>>getWinnngPositions(){
	 
	List<List<Position>>winingPositions = new ArrayList<>();
	
	 winingPositions.add(asList(new Position(1,1), new Position(1,2), new Position(1,3)));
	 winingPositions.add(asList(new Position(2,1), new Position(2,2), new Position(2,3)));
	 winingPositions.add(asList(new Position(3,1), new Position(3,2), new Position(3,3)));
	 
	 winingPositions.add(asList(new Position(1,1), new Position(2,1), new Position(3,1)));
	 winingPositions.add(asList(new Position(1,2), new Position(2,2), new Position(3,2)));
	 winingPositions.add(asList(new Position(1,3), new Position(2,3), new Position(3,2)));
	 
	 winingPositions.add(asList(new Position(1,1), new Position(2,2), new Position(3,3)));
	 winingPositions.add(asList(new Position(3,1), new Position(2,2), new Position(1,3)));
	 
	 return winingPositions;
}

/**
 * Stores all pairs of available rows and columns
 * @return list of all board's positions
 *
 *////////////
///////////// retourner les position tout les position 
////////////
static List <Position>getAllPostions(){
	List<Position> positions = new ArrayList<>();
	for (int i = 1; i <= 3; i++) {
		for (int j = 0; j <=3 ; j++) {
			positions.add(new Position(i,j));
		}
	}
	return positions;
}
/**
*
* @param nberOfFirstPlayerMovesInGame
* @param numberOfSecondPlayerMovesInGame
* @return true or false depending on the count of the player's moves
*/

 
static boolean playerTurn(int nbofFirstPlayerMove , int nbOfSecondPlayermove) {
	return nbofFirstPlayerMove == nbOfSecondPlayermove  || nbofFirstPlayerMove ==0 ;
}

///////
////// ne renvoie si la grille est remplie  
/////

static boolean isBoardisFull(List<Position> positionPrise) {
	return positionPrise.size() == 9;
}



static List<Position> getOpenPosition(List<Position>positionPrises)
{
    return getAllPostions().stream().filter(p -> !positionPrises.contains(p)).collect(Collectors.toList());
}

static Position nextAutomove(List<Position> positionPrises) {
	return getOpenPosition(positionPrises).get(0);
}
 
//////
/////  generer un deplacement AI
////
static List<Position> getOpenPositions(List<Move> takenPositions) {
    return getAllPostions().stream().filter(p -> !takenPositions.contains(p)).collect(Collectors.toList());
}
public static  Position nextMoveIA(List<Move> takenPositions, int deep,Game game ) {
	
		int i,j,temp;
		int max = MINVAL;
		Position res = new Position();
		Move pos= new Move();
		int maxi =0 ;
		
		int maxj = 0;
		for (i=0;i<3;i++) {
			for(j=0;j<3;j++)
			{
					pos.setLigne(i);
					pos.setCollonne(j);
					pos.setPlayerPieceCode(null);
				if (! takenPositions.contains(pos)) 
						{
							pos.setPlayerPieceCode(Piece.X);
							takenPositions.add(pos);
							temp = min(game ,deep -1 ,takenPositions);
							 if (temp > max )
							 {
								 max = temp;
								 maxi = i;
								 maxj = j;
							 }
							 pos.setCollonne(j);
							 pos.setLigne(i);
							 pos.setPlayerPieceCode(null);
							 takenPositions.set(takenPositions.size()-1, pos);
							
					    }
			}
			
		}
		pos.setPlayerPieceCode(Piece.X);
		pos.setCollonne(maxj);
		pos.setLigne(maxi);
		takenPositions.set(takenPositions.size()-1, pos);
		 
		res.setBoardCel(pos.getCollonne());
		res.setBoardRow(pos.getLigne());
		return res;
	}

public static int max (Game game , int deep ,List<Move> takenPositions ) {
	int max = MINVAL;
	int temp;
	Move pos= new Move();
	if (deep == 0 || moveservice.checkCurrentGameStatus(game) != GameStatus.IN_PROGRESS )
		return eval(game);
	for(int i=0;i<3;i++) 
	{
		for(int j=0;j<3;j++) 
		{
			pos.setLigne(i);
			pos.setCollonne(j);
			pos.setPlayerPieceCode(null);
		
			if (! takenPositions.contains(pos)) 
			{
				pos.setPlayerPieceCode(Piece.O);
				takenPositions.add(pos);
				temp= min (game,deep-1,takenPositions);
				if (temp > max) {
					max=temp;
				}
				pos.setPlayerPieceCode(null);
				takenPositions.set(takenPositions.size()-1, pos);
		     }
	     }
	
    }
	
	return max ;
}
public static  int min(Game game ,int deep , List< Move> takenPositions ) {
	int min = MAXVAL;
	int temp;
	Move pos= new Move();
	
	if(deep == 0  || moveservice.checkCurrentGameStatus(game) != GameStatus.IN_PROGRESS )
		return eval(game);
	
	for (int i=0;i<3;i++) {
		for(int j=0;j<3;j++)
		{
			pos.setLigne(i);
			pos.setCollonne(j);
			pos.setPlayerPieceCode(null);
		
	    if (!takenPositions.contains(pos)) {
	    pos.setPlayerPieceCode(Piece.X);
	    temp=max(game,deep-1,takenPositions);
	    if (temp < min)
	    	min = temp;
	    
	    pos.setLigne(i);
		pos.setCollonne(j);
		pos.setPlayerPieceCode(null);
		takenPositions.set(takenPositions.size()-1, pos);
	    }
	    }
		}
	return min;

}
Series series_j1 = new Series(0);
Series series_j2 = new Series(0);

public static void nb_series (Game game ,Series series_j1,Series series_j2, int n) {
	
	/// compte le nombre des series de n pions alignes de chain des joueur 
	
	int compteur1,compteur2,i,j;
	compteur1=0;
	compteur2 = 0 ;
	Move mov = new Move();
	
	//// diagonale decendante 
	
	for (i=0;i<3;i++) {
	mov.setCollonne(i);
	mov.setLigne(i);
	mov.setPlayerPieceCode(Piece.X);
	if (game.getDeplacements().contains(mov)) {
		compteur1++;
		compteur2 = 0 ;
		if (compteur1 == n) {
			series_j1.setNbSeries(series_j1.getNbSeries()+1);
		}
		mov.setPlayerPieceCode(Piece.O);
	}else if (game.getDeplacements().contains(mov)) {
		compteur2++;
		compteur1 = 0 ;
		if (compteur2== n) {
			series_j2.setNbSeries(series_j2.getNbSeries()+1);
		}
	}
	}
	compteur1=0;
	compteur2=0;
	
	//// diagonale montante 
	for(i=0;i<3;i++){
		mov.setCollonne(2-i);
		mov.setLigne(i);
		mov.setPlayerPieceCode(Piece.X);
        if(game.getDeplacements().contains(mov)){
             compteur1++;
             compteur2 = 0;

             if (compteur1 == n) {
     			series_j1.setNbSeries(series_j1.getNbSeries()+1);
     		}
     		mov.setPlayerPieceCode(Piece.O);
        }
        else if(game.getDeplacements().contains(mov)){
             compteur2++;
             compteur1 = 0;
      
             if(compteur2 == n){
            	 series_j2.setNbSeries(series_j2.getNbSeries()+1);
             }
        }       
   }
	
	//////ligne
	
	for (i=0;i<3;i++) {
		compteur1=0;
		compteur2=0;
		
		   ///// horizentalement 
		
		for (j=0;j<3;j++) {
			mov.setCollonne(j);
			mov.setLigne(i);
			mov.setPlayerPieceCode(Piece.X);
			if (game.getDeplacements().contains(mov)) {
				compteur1++;
				compteur2=0;
					   if (compteur1 == n) {
			     			series_j1.setNbSeries(series_j1.getNbSeries()+1);
			     		}
				 		mov.setPlayerPieceCode(Piece.O);
			}else if (game.getDeplacements().contains(mov)) {
				compteur2++;
				compteur1=0;
				  if(compteur2 == n){
		            	 series_j2.setNbSeries(series_j2.getNbSeries()+1);
		             }
				
			}
		}
	}

	////// verticalement 
	
	for (i=0;i<3;i++) {
		compteur1=0;
		compteur2=0;
		
		   ///// horizentalement 
		
		for (j=0;j<3;j++) {
			mov.setCollonne(i);
			mov.setLigne(j);
			mov.setPlayerPieceCode(Piece.X);
			if (game.getDeplacements().contains(mov)) {
				compteur1++;
				compteur2=0;
					   if (compteur1 == n) {
			     			series_j1.setNbSeries(series_j1.getNbSeries()+1);
			     		}
				 		mov.setPlayerPieceCode(Piece.O);
			}else if (game.getDeplacements().contains(mov)) {
				compteur2++;
				compteur1=0;
				  if(compteur2 == n){
		            	 series_j2.setNbSeries(series_j2.getNbSeries()+1);
		             }
				
			}
		}
	}
	
}

private static int eval (Game game ) {
	int nb_croix = 0;
	nb_croix = game.getDeplacements().size();
	   int vainqueur = gagnant(game);
       if(vainqueur != 0)
       {
         if( vainqueur == 1 )
         {
              return 1000 - nb_croix;
         }
         else if( vainqueur == 2 )
         {
              return -1000 + nb_croix;
         }
         else
         {
              return 0;
         }
       }
       Series series_j1 = new Series(0);
       Series series_j2 = new Series(0);
       nb_series(game,series_j1,series_j2,2);
       return series_j1 .getNbSeries()-series_j2.getNbSeries();
}

public static int gagnant (Game game ) {
	Series j1 = new Series(0);
	Series j2 = new Series(0);
	int res = 3;
	Move move = new Move ();
	 nb_series(game,j1,j2,3);
	   if(j1.getNbSeries() != 0)
       {  
           res = 1;
       }
       else if(j2.getNbSeries() != 0)
       {
            res = 2;
       }else {
    	   //Si le jeu n'est pas fini et que personne n'a gagné, on renvoie 0
           for(int i=0;i<3;i++) {
        	   for(int j=0;j<3;j++)
               {
        		    move.setLigne(i);
        			move.setCollonne(j);
        			move.setPlayerPieceCode(null);
        			if (game.getDeplacements().contains(move)) {
        				res = 0;
        			}
               }
           }
    	   
       }
	
	 //Si le jeu est fini et que personne n'a gagné, on renvoie 3
       return res;
}

}




