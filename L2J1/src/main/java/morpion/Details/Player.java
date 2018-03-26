package Details;

import Enumeration.Piece;

public class Player {
private String id;
private Piece piece ;
public Player(String id, Piece piece) {
	this.id = id;
	this.piece = piece;
}
public String getId() {
	return id;
}
public Piece getPiece() {
	return piece;
}


}
