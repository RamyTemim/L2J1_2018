package morpion;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameLogic {
private final  Game game;
public GameLogic(Game game){
	this.game = game;
}
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
static List<Position> getOpenPositions(List<Position> takenPositions) {
    return getAllPostions().stream().filter(p -> !takenPositions.contains(p)).collect(Collectors.toList());
}
static Position nextAutoMove(List<Position> takenPositions) {
    return getOpenPositions(takenPositions).get(0);
}




}




