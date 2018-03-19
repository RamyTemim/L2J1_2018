package TicTacToe;

public enum PlayerState {
	IN_PROGRESS, 
	WIN, 
	LOSS, 
	DRAW;
	public Boolean isInProgress() {
		return this == IN_PROGRESS;
	}
	public boolean isWin() {
		return this == WIN;
	}
	
	public boolean isLoss() {
		return this == LOSS;
	}
	
	public boolean isDraw() {
		return this == DRAW;
	}
	
	public boolean isGameOver() {
		return this == WIN || this == LOSS || this == DRAW;
	}
	
};
