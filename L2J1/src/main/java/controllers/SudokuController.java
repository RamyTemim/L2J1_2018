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
	public Grille nouvellePartieFacile() {
		Grille facile = new Grille();
		Solution solution = new Solution(facile);
		solution.generateSolvedSudoku();
		Generator grillefacile = new Generator(facile);
		grillefacile.generateEasyLevel(solution.mygrille);
		return facile;
	}

	@RequestMapping(value = "/sudokuNormal", method = RequestMethod.GET)
	public Grille nouvellePartieNormal() {
		Grille normal = new Grille();
		Solution solution = new Solution(normal);
		solution.generateSolvedSudoku();
		Generator grillenormal = new Generator(normal);
		grillenormal.generateNormalLevel(solution.mygrille);
		return normal;
	}

	@RequestMapping(value = "/sudokuDifficile", method = RequestMethod.GET)
	public Grille nouvellePartieDifficile() {
		Grille difficile = new Grille();
		Solution solution = new Solution(difficile);
		solution.generateSolvedSudoku();
		Generator grilledifficile = new Generator(difficile);
		grilledifficile.generateHardLevel(solution.mygrille);
		return difficile;
	}
}
