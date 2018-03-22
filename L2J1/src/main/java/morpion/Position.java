package morpion;

public class Position {
private int boardRow;
private int boardCel;
private String id ;
public Position(int boardRow, int boardCel) {
	this.boardRow = boardRow;
	this.boardCel = boardCel;
}

public Position () {}
public Position(int boardRow, int boardCel, String id) {

	this.boardRow = boardRow;
	this.boardCel = boardCel;
	this.id = id;
}


public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public int getBoardRow() {
	return boardRow;
}
public void setBoardRow(int boardRow) {
	this.boardRow = boardRow;
}
public int getBoardCel() {
	return boardCel;
}
public void setBoardCel(int boardCel) {
	this.boardCel = boardCel;
}

}
