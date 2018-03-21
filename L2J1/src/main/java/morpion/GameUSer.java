package UserOpt;

import Enumeration.GameType;
import Enumeration.Piece;

public class GameUSer {
  ///////////  cette class contiendras les valeur taper par l utilisateur .
	
	private GameType gameType;
	private Piece piece;
	public GameUSer(GameType gameType, Piece piece) {
		super();
		this.gameType = gameType;
		this.piece = piece;
	}
	public GameType getGameType() {
		return gameType;
	}
	public Piece getPiece() {
		return piece;
	}
	
	
}
