package morpion;

import morpion.Game;
import java.util.List;
import java.util.ArrayList;

public class Game {
private String id ;
private Player firstPlayer;
private Player secondPlayer;
private String firstPlayerPiece;
private String status;
private List<Move> deplacements = new ArrayList<>();
private List<Position> playerPosition = new ArrayList<>();


 


public Game(String id, Player firstPlayer, Player secondPlayer, String firstPlayerPiece, String status,
		List<Move> deplacements, List<Position> playerPosition) {
	this.id = id;
	this.firstPlayer = firstPlayer;
	this.secondPlayer = secondPlayer;
	this.firstPlayerPiece = firstPlayerPiece;
	this.status = status;
	this.deplacements = deplacements;
	this.playerPosition = playerPosition;
}
public Game () {};
public Game (Player firstPlayer,String firstPlayerPiece, String id ) {
	
	this.id = id;
	this.firstPlayer = firstPlayer;
	this.firstPlayerPiece = firstPlayerPiece;
}



public List<Position> getPlayerPosition() {
	return playerPosition;
}
public void setPlayerPosition(Position p) {
	this.playerPosition.add(p);
}
public void setDeplacements(List<Move> deplacements) {
	this.deplacements = deplacements;
}
public List<Move> getDeplacements() {
	return deplacements;
}

public void setDeplacements(Move m) {
	this.deplacements.add(m);
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public Player getFirstPlayer() {
	return firstPlayer;
}

public void setFirstPlayer(Player firstPlayer) {
	this.firstPlayer = firstPlayer;
}

public Player getSecondPlayer() {
	return secondPlayer;
}

public void setSecondPlayer(Player secondPlayer) {
	this.secondPlayer = secondPlayer;
}

public String getFirstPlayerPiece() {
	return firstPlayerPiece;
}

public void setFirstPlayerPiece(String firstPlayerPiece) {
	this.firstPlayerPiece = firstPlayerPiece;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


}
