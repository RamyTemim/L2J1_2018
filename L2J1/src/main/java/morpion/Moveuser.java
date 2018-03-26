package morpion;

public class Moveuser {
private int boardRow;
private int BoardCel;
public Moveuser() {}
public Moveuser(int boardRow, int boardCel) {

	this.boardRow = boardRow;
	BoardCel = boardCel;
}
public int getBoardRow() {
	return boardRow;
}
public int getBoardCel() {
	return BoardCel;
}

}
