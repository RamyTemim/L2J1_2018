package sudoku;

public class AbstractGrid implements SudokuGenerator {

	int[][] solvedboard = new int[BOARD_WIDTH][BOARD_HEIGHT];
	int[][] grid = new int[BOARD_WIDTH][BOARD_HEIGHT];

	@Override
	public int[][] getSolvedSudoku() {
		return solvedboard;
	}

	@Override
	public int[][] generateRestSudokuGrid(String difficulty) {
		affect(nextBoard(), grid);
		affect(grid, solvedboard);
		
		switch (difficulty) {
		case SudokuGenerator.EASY_GRID:
			return makeHoles(grid, 20);

		case SudokuGenerator.MEDIUM_GRID:
			return makeHoles(grid, 40);

		case SudokuGenerator.HARD_GRID:
			return makeHoles(grid, 60);
		default:
			break;
		}
		return null;
	}

}
