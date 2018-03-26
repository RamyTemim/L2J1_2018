package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import morpion.Game;
import morpion.GameService;
import morpion.GameUSer;
import morpion.Move;
import morpion.MoveService;
import morpion.Moveuser;
import morpion.Player;
import morpion.PlayerService;
import morpion.Position;

import java.util.List;

@RestController
@RequestMapping("/Morpion")
public class MorpionController {

	
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

    @Autowired
    private MoveService moveService;

    private Game game;
    private Player currentPlayer;


    ///
    ///     crrer un nouvel deplacement
    ///

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Move createMove(@RequestBody Moveuser createMove) {

        Move move = moveService.createMove(game ,currentPlayer, createMove);
        gameService.updateGameStatus(game, moveService.checkCurrentGameStatus(game));

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
