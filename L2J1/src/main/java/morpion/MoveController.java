package Controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Details.Game;
import Details.Move;
import Details.Player;
import Details.Position;
import Service.GameService;
import Service.MoveService;

import UserOpt.Moveuser;


@RestController
@RequestMapping("/move")
public class MoveController {

    @Autowired
    private MoveService moveService;

    @Autowired
    private GameService gameService;
    private Game game;
    private Player currentPlayer;
     
    
      ///
     ///     crrer un nouvel deplacement 
    ///
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Move createMove(@RequestBody Moveuser createMove) {
 
        Move move = moveService.createMove(game ,currentPlayer, createMove);
       /* gameService.updateGameStatus(game.getId(), moveService.checkCurrentGameStatus(game));*/
       
        return move;
}
    
    

    
      /////
     ///// envoiyer les deplacement pour checker les position valide
    /////
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Move> getMovesInGame() {
      return moveService.getMovesInGame(game);
}
    
    
    
     ////
    ////     deplacement intelgence artificiel 
   ////
    @RequestMapping(value = "/autocreate", method = RequestMethod.GET)
    public Move autoCreateMove() {
    	
    
       Move move = moveService.autoCreateMove(game);
       gameService.updateGameStatus( game  , moveService.checkCurrentGameStatus(game));
       return move;
}
    
    
    
    
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public List<Position> validateMoves() {
      
        return moveService.getPlayerMovePositionsInGame(game, currentPlayer);
}
    
    
    
    
    /////
	////	 verifier a qui le tour
	///
    
    @RequestMapping(value = "/turn", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean isPlayerTurn() {
  
        return moveService.isPlayerTurn(game, game.getFirstPlayer(),
                game.getSecondPlayer());
}
    
}
