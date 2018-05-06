package controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Morpion.Reset;
import pfc.pfc;

@RestController
@RequestMapping("/pfc")
public class PFCController {
	
	pfc p = new pfc();
	
	/* reçoit l'id de la case cliqué par le front et la place dans le back */
	@RequestMapping(value="/mark" , method = RequestMethod.POST)
	 public int move(@RequestBody int idcase ) {
		 return   p.markMove(idcase);
	}
	
	/* affiche le résultat */
	 @RequestMapping(value = "/resultat", method = RequestMethod.GET)
	    public  int resultat () {
	        return p.resultat();	        	
	 }
	 
	 /* réinitiliase les variables à chaque coup */ 
	 @RequestMapping(value="/reset" , method = RequestMethod.POST)
	 public int reset(@RequestBody int rep) {
		 	return  p.reset(rep);	 
	 }	
}
