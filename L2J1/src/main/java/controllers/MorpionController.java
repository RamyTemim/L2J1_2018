package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorpionController {
	/**
	 * Play a new game vs Computer
	 * 
	 * @return an empty grid
	 */
	@RequestMapping(value = "/morpionVsIa", method = RequestMethod.GET)
	public void NewGameIaVsPlayer() {

	}

	/**
	 * Play a new game vs Player
	 * 
	 * @return an empty grid
	 */
	@RequestMapping(value = "/morpionVsPlayer", method = RequestMethod.GET)
	public void NewGamePlayerVsPlayer() {

	}
}
