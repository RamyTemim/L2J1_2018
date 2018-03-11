package sudoku;

public class HardGrid implements SudokuGenerator {

	@Override
	public void generateSudokuGrid() {
		print(nextBoard(60));
		
	}

	@Override
	public int[][] generateRestSudokuGrid() {
		return nextBoard(60);
	}
}
