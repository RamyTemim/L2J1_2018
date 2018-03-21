package Controller;
import Service.*;
import UserOpt.GameUSer;
import Details.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Morpion")
public class GameController {

	 @Autowired
	 GameService gameService;
	 
	 @Autowired
	 PlayerService playerService;
	 //// creeer le jeu de morpion 
	 
	 @RequestMapping(value = "/create", method = RequestMethod.POST)
	 public Game createNewGame(@RequestBody GameUSer gameuser ) {
		 Game game = gameService.createNewGame(gameuser); 
		 return game;
	 }
	   

}
