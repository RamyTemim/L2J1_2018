package TicTacToe;

import java.util.List;



public class Game {
	private Grille grille;
	private PlayerState playerState;
	private Boolean playerGoFirst;
	private boolean nextMoveX;
	
	public Game() {
		startNew();
	}
	/// start a new game 
	private void startNew() {
	     playerGoFirst = true;
	     nextMoveX = true;
	     playerState = PlayerState.IN_PROGRESS;
	     if (grille == null) {
	    	 grille = new Grille();
	     }else {
	    	 grille.reset();
	     }
	}
	public Grille getGrille () {
		return grille ;
	}
	
		
	public void coucherCase(String caseId) {
		setTileValue (grille.get(caseId));
	}
	public void coucherCaseRandom() {
		setTileValue( grille.getRandomAvailable() );
	}
	private void setTileValue( Tile tile ) {
		if ( isGameOver() || !tile.isEmpty() ) {
			return;
		}
		tile.setValue(nextMoveX ? Tile.Value.X : Tile.Value.O);
		nextMoveX = !(nextMoveX);
		Tile.Value winValue = evaluateWinVAlue();
		if (winValue != null) {
			Tile.Value playerValue = playerGoFirst ? Tile.Value.X : Tile.Value.O;
			playerState = winValue == playerValue ? playerState.WIN : playerState.LOSS;
			
		}else 
			playerState = grille.isFull() ? PlayerState.DRAW : PlayerState.IN_PROGRESS;
		
	
	}
	
	/// evalouer la progression de joue 
	private Tile.Value evaluateWinVAlue(){
		
		List<List<Tile>> allLines= grille.getAllLines();
		for (List<Tile> line : allLines) {
			Tile first = line.get(0);
			if (first.isEmpty())
				continue;
			if ( line.stream().allMatch(t -> t.getValue() == first.getValue() )) {
				return first.getValue();
			}
		}
		return null;
		
	}

	public void setPlayerGoFirst( boolean flag ) {
		this.playerGoFirst = flag;
	}

	public boolean isPlayerGoFirst() {
		return playerGoFirst;
	}
	
	public boolean isGameOver() {
		return playerState.isGameOver();
	}

	public void reset() {
		startNew();
	}
	
	public PlayerState getPlayerState() {
		return playerState;
	}
}
	
