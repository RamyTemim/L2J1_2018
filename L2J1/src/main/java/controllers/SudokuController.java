package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import services.SudokuService;
import sudoku.AbstractGrid;


@RestController
@RequestMapping("/sudoku")
public class SudokuController {

	@Autowired
	SudokuService service;
	
	
	/**
	 * Generate an easy sudoku (20 holes)
	 * 
	 * @return easy sudoku grid
	 */
	@RequestMapping(value = "/sudokuFacile", method = RequestMethod.GET)
	public int[][] EasyGameSudoku() {
		AbstractGrid easy = new AbstractGrid();
		easy.affect(easy.generateRestSudokuGrid("easy"), service.getGrid());
		easy.affect(easy.getSolvedSudoku(), service.getSolvedboard());
		service.getLog().info("generate easy sudoku");
		return service.getGrid();
	}

	/**
	 * Generate a medium sudoku (40 holes)
	 * 
	 * @return medium sudoku grid
	 */
	@RequestMapping(value = "/sudokuNormal", method = RequestMethod.GET)
	public int[][] MediumGameSudoku() {
		AbstractGrid medium = new AbstractGrid();
		medium.affect(medium.generateRestSudokuGrid("medium"), service.getGrid());
		medium.affect(medium.getSolvedSudoku(), service.getSolvedboard());
		service.getLog().info("generate normal sudoku");
		return service.getGrid();
	}

	/**
	 * Generate a hard sudoku (60 holes)
	 * 
	 * @return hard sudoku grid
	 */
	@RequestMapping(value = "/sudokuDifficile", method = RequestMethod.GET)
	public int[][] HardGameSudoku() {
		AbstractGrid hard = new AbstractGrid();
		hard.affect(hard.generateRestSudokuGrid("hard"), service.getGrid());
		hard.affect(hard.getSolvedSudoku(), service.getSolvedboard());
		service.getLog().info("generate hard sudoku");
		return service.getGrid();
	}

	/**
	 * 
	 * @return solved sudoku for any difficulty
	 */
	@RequestMapping(value = "/solvedSudoku", method = RequestMethod.GET)
	public int[][] EasyGameSudokuSolved() {
		service.getLog().info("get sudoku solution");
		return service.getSolvedboard();
	}
	

}
