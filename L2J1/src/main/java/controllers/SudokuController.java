package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sudoku.*;

@RestController
public class SudokuController {

	int[][] solvedboard = new int[9][9];
	int[][] grid = new int[9][9];

	/**
	 * Generate an easy sudoku (20 holes)
	 * 
	 * @return easy sudoku grid
	 */
	@RequestMapping(value = "/sudokuFacile", method = RequestMethod.GET)
	public int[][] EasyGameSudoku() {
		EasyGrid easy = new EasyGrid();
		easy.affect(easy.generateRestSudokuGrid(), grid);
		easy.affect(easy.getSolvedSudoku(), solvedboard);
		return grid;
	}

	/**
	 * Generate a medium sudoku (40 holes)
	 * 
	 * @return medium sudoku grid
	 */
	@RequestMapping(value = "/sudokuNormal", method = RequestMethod.GET)
	public int[][] MediumGameSudoku() {
		MediumGrid medium = new MediumGrid();
		medium.affect(medium.generateRestSudokuGrid(), grid);
		medium.affect(medium.getSolvedSudoku(), solvedboard);
		return grid;
	}

	/**
	 * Generate a hard sudoku (60 holes)
	 * 
	 * @return hard sudoku grid
	 */
	@RequestMapping(value = "/sudokuDifficile", method = RequestMethod.GET)
	public int[][] HardGameSudoku() {
		HardGrid hard = new HardGrid();
		hard.affect(hard.generateRestSudokuGrid(), grid);
		hard.affect(hard.getSolvedSudoku(), solvedboard);
		return grid;
	}

	/**
	 * 
	 * @return solved sudoku for any difficulty
	 */
	@RequestMapping(value = "/solvedSudoku", method = RequestMethod.GET)
	public int[][] EasyGameSudokuSolved() {
		return solvedboard;
	}

}
