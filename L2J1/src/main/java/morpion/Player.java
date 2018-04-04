package morpion;



public class Player {
private String id;
private String piece ;
public Player(String id, String piece) {
	this.id = id;
	this.piece = piece;
}
public String getId() {
	return id;
}
public String getPiece() {
	return piece;
}


}
