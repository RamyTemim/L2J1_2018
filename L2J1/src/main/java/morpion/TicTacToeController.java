package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import TicTacToe.Game;

@Controller
@SessionAttributes("game")
public class TicTacToeController {
 

	@RequestMapping (value = "/" , method= RequestMethod.GET)
	public String index ( @ModelAttribute("game") Game game ) {
		return "index";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String markTile(
			@ModelAttribute("game")Game game,
			@RequestParam("title_id") String titleId,
			@RequestParam(value ="new_game", required =false , defaultValue= "false")boolean newGame,
			@RequestParam(value = "player_go_first", required = false, defaultValue = "false") boolean playerGoFirst) {
		
		if (newGame ) {
			game.reset();
			game.setPlayerGoFirst(playerGoFirst);
			if (! playerGoFirst) {
			    /// give computer a mall advantage by always placing X in the center as its first move 
				game.coucherCase("1-1");
				
			}
		}else {
			game.coucherCase(titleId);// player turn
			game.coucherCaseRandom();// computer turn
		}
		return "index";
	}
	@ModelAttribute("game")
	public Game PolulateGame() {
		return new Game();
	}
	
}
