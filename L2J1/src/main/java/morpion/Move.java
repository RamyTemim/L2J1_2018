package morpion;


public class Move {
private String id ;
private int ligne;
private int collonne;
private Player player;
private Piece playerPieceCode;
private GameStatus status;




public Move() {};

public Move(String id, int ligne, int collonne, Player player, Piece playerPieceCode, GameStatus status) {
	super();
	this.id = id;
	this.ligne = ligne;
	this.collonne = collonne;
	this.player = player;
	this.playerPieceCode = playerPieceCode;
	this.status = status;
}


public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getLigne() {
	return ligne;
}
public void setLigne(int ligne) {
	this.ligne = ligne;
}
public int getCollonne() {
	return collonne;
}
public void setCollonne(int collonne) {
	this.collonne = collonne;
}
public Player getPlayer() {
	return player;
}
public void setPlayer(Player player) {
	this.player = player;
}
public Piece getPlayerPieceCode() {
	return playerPieceCode;
}
public void setPlayerPieceCode(Piece playerPieceCode) {
	this.playerPieceCode = playerPieceCode;
}
public GameStatus getStatus() {
	return status;
}
public void setStatus(GameStatus status) {
	this.status = status;
}






}
