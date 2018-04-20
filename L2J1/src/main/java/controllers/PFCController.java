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
	
	@RequestMapping(value="/mark" , method = RequestMethod.POST)
	 public int move(@RequestBody int idcase ) {
		 return   p.markMove(idcase);
	}
	
	 @RequestMapping(value = "/resultat", method = RequestMethod.GET)
	    public  int resultat () {
	        return p.resultat();	        	
	 }
	 
	 @RequestMapping(value="/reset" , method = RequestMethod.POST)
	 public int reset(@RequestBody int rep) {
		 	return  p.reset(rep);	 
	 }	
}
