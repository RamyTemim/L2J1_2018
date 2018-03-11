package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sudoku.*;

@RestController
public class SudokuController {

	/**
	 * Generate an easy sudoku (20 holes)
	 * 
	 * @return easy sudoku grid
	 */
	@RequestMapping(value = "/sudokuFacile", method = RequestMethod.GET)
	public int[][] EasyGameSudoku() {
		EasyGrid easy = new EasyGrid();
		easy.generateSudokuGrid();
		return easy.generateRestSudokuGrid();
	}

	/**
	 * Generate a medium sudoku (40 holes)
	 * 
	 * @return medium sudoku grid
	 */
	@RequestMapping(value = "/sudokuNormal", method = RequestMethod.GET)
	public int[][] MediumGameSudoku() {
		MediumGrid medium = new MediumGrid();
		medium.generateSudokuGrid();
		return medium.generateRestSudokuGrid();

	}

	/**
	 * Generate a hard sudoku (60 holes)
	 * 
	 * @return hard sudoku grid
	 */
	@RequestMapping(value = "/sudokuDifficile", method = RequestMethod.GET)
	public int[][] HardGameSudoku() {
		HardGrid hard = new HardGrid();
		hard.generateSudokuGrid();
		return hard.generateRestSudokuGrid();
	}

}
