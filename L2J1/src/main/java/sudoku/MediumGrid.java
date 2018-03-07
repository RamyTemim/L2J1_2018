package sudoku;

public class MediumGrid implements SudokuGenerator {

	@Override
	public void generateSudokuGrid() {
		print(nextBoard(40));
		
	}

	@Override
	public int[][] generateRestSudokuGrid() {
		return nextBoard(40);
	}
}
