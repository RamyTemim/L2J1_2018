package sudoku;

import java.util.Random;

public interface SudokuGenerator {

	static final int BOARD_WIDTH = 9;
	static final int BOARD_HEIGHT = 9;

	int[][] generateRestSudokuGrid();
	
	/**
	 * This method will be overridden based on difficulty
	 * 
	 * @param difficulty
	 */
	 void generateSudokuGrid();

	/**
	 * Driver method for nextBoard.
	 *
	 * @param difficult
	 *            the number of blank spaces to insert
	 * @return board, a partially completed 9x9 Sudoku board
	 */
	default int[][] nextBoard(int difficulty) {
		int[][] board = new int[BOARD_WIDTH][BOARD_HEIGHT];
		nextCell(board, 0, 0);
		makeHoles(board, difficulty);
		return board;
	}

	/**
	 * Recursive method that attempts to place every number in a cell.
	 *
	 * @param x
	 *            x value of the current cell
	 * @param y
	 *            y value of the current cell
	 * @return true if the board completed legally, false if this cell has no legal solutions.
	 */
	default boolean nextCell(int[][]board, int x, int y) {
		int nextX = x;
		int nextY = y;
		int[] toCheck = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random r = new Random();
		int tmp = 0;
		int current = 0;
		int top = toCheck.length;

		for (int i = top - 1; i > 0; i--) {
			current = r.nextInt(i);
			tmp = toCheck[current];
			toCheck[current] = toCheck[i];
			toCheck[i] = tmp;
		}

		for (int i = 0; i < toCheck.length; i++) {
			if (legalMove(board, x, y, toCheck[i])) {
				board[x][y] = toCheck[i];
				if (x == 8) {
					if (y == 8)
						return true;// We're done! Yay!
					else {
						nextX = 0;
						nextY = y + 1;
					}
				} else {
					nextX = x + 1;
				}
				if (nextCell(board, nextX, nextY))
					return true;
			}
		}
		board[x][y] = 0;
		return false;
	}

	/**
	 * Given a cell's coordinates and a possible number for that cell, determine if that number can be inserted into said cell legally.
	 *
	 * @param x x value of cell
	 * @param y y value of cell
	 * @param current The value to check in said cell.
	 * @return True if current is legal, false otherwise.
	 */
	default boolean legalMove(int[][]board, int x, int y, int current) {
		for (int i = 0; i < 9; i++) {
			if (current == board[x][i])
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if (current == board[i][y])
				return false;
		}
		int cornerX = 0;
		int cornerY = 0;
		if (x > 2)
			if (x > 5)
				cornerX = 6;
			else
				cornerX = 3;
		if (y > 2)
			if (y > 5)
				cornerY = 6;
			else
				cornerY = 3;
		for (int i = cornerX; i < 10 && i < cornerX + 3; i++)
			for (int j = cornerY; j < 10 && j < cornerY + 3; j++)
				if (current == board[i][j])
					return false;
		return true;
	}

	/**
	 * Given a completed board, replace a given amount of cells with 0s (to represent blanks)
	 *
	 * @param holesToMake How many 0s to put in the board.
	 */
	static void makeHoles(int[][]board, int holesToMake) {
		/*
		 * We define difficulty as follows: Easy: 32+ clues (49 or fewer holes) Medium: 27-31 clues (50-54 holes) Hard: 26 or fewer clues (54+ holes) This is human difficulty, not algorithmically
		 * (though there is some correlation)
		 */
		double remainingSquares = 81;
		double remainingHoles = (double) holesToMake;

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				double holeChance = remainingHoles / remainingSquares;
				if (Math.random() <= holeChance) {
					board[i][j] = 0;
					remainingHoles--;
				}
				remainingSquares--;
			}
	}
	
	/**
	 *Prints a representation of board on stdout
	 */
	default void print(int[][]board)
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
				System.out.print(board[i][j] + "  ");
			System.out.println();
		}
		System.out.println();
	}

}
