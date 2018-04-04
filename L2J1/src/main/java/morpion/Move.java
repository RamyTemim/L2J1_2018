package morpion;


public class Move {
private String id ;
private int ligne;
private int collonne;
private Player player;
private String playerPieceCode;
private String status;




public Move() {};

public Move(String id, int ligne, int collonne, Player player, String playerPieceCode, String status) {
	super();
	this.id = id;
	this.ligne = ligne;
	this.collonne = collonne;
	this.player = player;
	this.playerPieceCode = playerPieceCode;
	this.status = status;
}

public Move(int ligne ,int collonne ,String playerPieceCode ) {
	this.ligne = ligne;
	this.collonne = collonne;
	this.playerPieceCode = playerPieceCode;
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
public String getPlayerPieceCode() {
	return playerPieceCode;
}
public void setPlayerPieceCode(String playerPieceCode) {
	this.playerPieceCode = playerPieceCode;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}






}
