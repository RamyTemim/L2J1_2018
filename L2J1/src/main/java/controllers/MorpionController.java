package controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Morpion.CaseInput;
import Morpion.Joueur;
import Morpion.TypeGame;
import services.MorpionService;


@RestController
@RequestMapping("/morpion")
public class MorpionController {

	

    
	
	MorpionService gameService = new MorpionService(); 
	
	@RequestMapping("/pagehello")
	public String sayHi() {
		return "Hello there !!!!!!!!! ";
	}
	 @RequestMapping(value = "/creategame", method = RequestMethod.POST)
	 public void createNewGame(@RequestBody TypeGame gameuser ) {
	        gameService.createNewGame(gameuser); 
		
	 }
	 
	 @RequestMapping(value="/move" , method = RequestMethod.POST)
	 public int  moveuser(@RequestBody CaseInput idcase ) {
		 return   gameService.markMove(idcase);
		  
	 }	
	 @RequestMapping(value = "/gamestatus", method = RequestMethod.GET)
	    public  int getGameStatus (Joueur j) {
	        return gameService.gameStatus();
	        	
	        }
	 @RequestMapping(value = "/player", method = RequestMethod.GET)
	    public  int getJoueur () {
	        return gameService.gamePlayer();
	        	
	        }
	 
	 @RequestMapping(value="/reset" , method = RequestMethod.POST)
	 public int  moveuser(@RequestBody int  rep ) {
		 return   gameService.clear(rep);
		  
	 }	
	    

    @RequestMapping(value = "/automove", method = RequestMethod.GET)
    public int  autoCreateMove(){
       return  gameService.iaMove();
  
    }

    }
	 
