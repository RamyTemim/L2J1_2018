package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sudoku.*;

@RestController
public class SudokuController {

	@RequestMapping(value = "/sudoku", method = RequestMethod.GET)
	public void menu() {
		/* TODO : creer un menu choix pour : choisir la difficulté (le choix de la difficulté nous renvoins vers les methods ci-dessous)
		 *  -  choisir la difficulté (le choix de la difficulté nous renvoins vers les fonction ci-dessous)
		 *  -  lire les regle du jeux
		 *  -  opition
		 *  PS: cette method va faire appel au methods definie ci-dessous
		 * */
	}

	@RequestMapping(value = "/sudokuFacile", method = RequestMethod.GET)
	public void EasyGameSudoku() {
		EasyGrid easy = new EasyGrid();
		easy.generateSudokuGrid();
		// TODO return easy.generateSudokuGrid();
	}

	@RequestMapping(value = "/sudokuNormal", method = RequestMethod.GET)
	public void MediumGameSudoku() {
		MediumGrid medium = new MediumGrid();
		medium.generateSudokuGrid();
	}

	@RequestMapping(value = "/sudokuDifficile", method = RequestMethod.GET)
	public void HardGameSudoku() {
		HardGrid hard = new HardGrid();
		hard.generateSudokuGrid();
	}
}
