package morpion;




public class GameUSer {
  ///////////  cette class contiendras les valeur taper par l utilisateur .
	
	private String gameType;
	private String piece;
	public GameUSer(String gameType, String piece) {
		super();
		this.gameType = gameType;
		this.piece = piece;
	}
	public String getGameType() {
		return gameType;
	}
	public String getPiece() {
		return piece;
	}
	
	
}
