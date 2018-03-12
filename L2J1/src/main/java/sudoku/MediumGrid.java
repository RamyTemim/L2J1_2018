package sudoku;

public class MediumGrid implements SudokuGenerator {

	int[][] solvedboard = new int[BOARD_WIDTH][BOARD_HEIGHT];
	int[][] grid = new int[BOARD_WIDTH][BOARD_HEIGHT];

	@Override
	public int[][] generateRestSudokuGrid() {
		affect(nextBoard(), grid);
		affect(grid, solvedboard);
		return makeHoles(grid, 60);
	}

	@Override
	public int[][] getSolvedSudoku() {
		return solvedboard;
	}
}
