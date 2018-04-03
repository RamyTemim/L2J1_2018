package morpion;

import morpion.Game;
import java.util.List;
import java.util.ArrayList;

public class Game {
private GameType id ;
private Player firstPlayer;
private Player secondPlayer;
private Piece firstPlayerPiece;
private GameStatus status;
private List<Move> deplacements = new ArrayList<>();
private List<Position> playerPosition = new ArrayList<>();


 


public Game(GameType id, Player firstPlayer, Player secondPlayer, Piece firstPlayerPiece, GameStatus status,
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
public Game (Player firstPlayer,Piece firstPlayerPiece, GameType id ) {
	
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

public GameType getId() {
	return id;
}

public void setId(GameType id) {
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

public Piece getFirstPlayerPiece() {
	return firstPlayerPiece;
}

public void setFirstPlayerPiece(Piece firstPlayerPiece) {
	this.firstPlayerPiece = firstPlayerPiece;
}

public GameStatus getStatus() {
	return status;
}
public void setStatus(GameStatus status) {
	this.status = status;
}


}
