package controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Morpion.CaseInput;
import Morpion.Joueur;
import Morpion.Reset;

import services.MorpionService;


@RestController
@RequestMapping("/morpion")
public class MorpionController {

	

    
	
	MorpionService gameService = new MorpionService(); 
	
	/*reçoit l'id d'une case et la place dans la grille du back*/
	 
	 @RequestMapping(value="/move" , method = RequestMethod.POST)
	 public int  moveuser(@RequestBody CaseInput idcase ) {
		 return   gameService.markMove(idcase);
		  
	 }	
	 
	 /* renvoie l'état du jeu et change le tour du joueur à chaque appel*/
	 @RequestMapping(value = "/gamestatus", method = RequestMethod.GET)
	    public  int getGameStatus (Joueur j) {
	        return gameService.gameStatus();
	        	
	        }
	 
	 /* renvoie le tour du joueur qui doit joue */
	 @RequestMapping(value = "/player", method = RequestMethod.GET)
	    public  int getJoueur () {
	        return gameService.gamePlayer();
	        	
	        }
	 
	 /* réinitialise la grille, l'état du jeu et le tour à leurs état initiaux */
	 @RequestMapping(value="/reset" , method = RequestMethod.POST)
	 public int  moveuser(@RequestBody Reset  rep ) {
		 return   gameService.clear(rep);
		  
	 }	
	    
	 /* renvoie l'id de la case que l'IA a choisi */
    @RequestMapping(value = "/automove", method = RequestMethod.GET)
    public int  autoCreateMove(){
       return  gameService.iaMove();
  
    }

    }
	 
