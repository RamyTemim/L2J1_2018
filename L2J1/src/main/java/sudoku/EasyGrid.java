package sudoku;

public class EasyGrid implements SudokuGenerator {

	@Override
	public void generateSudokuGrid() {
		print(nextBoard(20));

	}

	@Override
	public int[][] generateRestSudokuGrid() {
		return nextBoard(20);
	}
}