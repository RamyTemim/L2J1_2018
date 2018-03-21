package TicTacToe;

public class Tile {
	/// tile veut dire case 
	/// tant que case est un mot specifique en java .
 public enum Value {
	 EMPTY (""),
	 X("x"),
	 O("o");
	 private String text;
	 private Value (String text ) {
		 this.text = text;
	 }
	 @Override
	 public String toString() {
			return text;
		}
	 
	 
 }
 private Value value;
 private int rowIndex;
 private int columnIndex;
 
 ///// initailiser la case avec le constructeur 
 public Tile( int rowIndex, int columnIndex ) {
		this.value = Value.EMPTY;
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}
 ////// renvoie le row index 
 
 public int getRowIndex() {
		return rowIndex;
	}
 ////// renvooie le column index 
 
 public int getColumnIndex() {
		return columnIndex;
	}
 //// renvoie le row and column en id chaine de caractere 
 public String getId() {
		return this.rowIndex + "-" + this.columnIndex;
	}
 ///// verifier si la case est vide 
 public boolean isEmpty() {
		return this.value == Value.EMPTY;
	}
 
 ///// modifier la valeur de la case 
 public void setValue( Value value ) {
		this.value = value;
	}
 ///// renvoie la valuer de la case 
 public Value getValue() {
		return value;
	}
///////////// renvoie l id de la case row +column 
	@Override
	public String toString() {
		return value.toString();
	}
 
 
}
