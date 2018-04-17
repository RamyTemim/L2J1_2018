package services;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Morpion.CaseInput;
import Morpion.Game;
import Morpion.Grille;
import Morpion.Joueur;
import Morpion.TypeGame;




public class MorpionService {
	
	 Game game = new Game();
	 Joueur progress = new Joueur(4);
	 Grille grille = new Grille();
	 Joueur  joueur1 = new Joueur(1, 'X');
	 Joueur joueur2 = new Joueur(2, 'O');
	 Joueur currentJoueur = joueur1;
	 int nbmove = 0;
		public void createNewGame( TypeGame gameuser ) {
		 
		  // gameuser a les choit de l utilisateur a propos de morpion 


		 if (gameuser.getGameType() == "COMPUTER") {
			  game.setGameType("COMPUTER");
				  
		 }else {
			 game.setGameType("HUMAIN");
		 }
			
  	  }
		public void swapTurn() {
			if (currentJoueur.equals(joueur1))
				currentJoueur = joueur2;
			else
				currentJoueur = joueur1;
			
		}
		
		public int temp(int a ) {
			return a ;
		}
		   @JsonIgnore
	    public int markMove( CaseInput  idcase ) {
	    	nbmove = nbmove +1;
	     grille.setCaseContenu(idcase.getIdcase(), currentJoueur.getCaractere());
	     game.setGrille(grille);
	     
	    return  idcase.getIdcase();
			 
	    }
	  
	    @JsonIgnore
	 public int  gameStatus() {
	    	 
			   if(grille.getGagnant() != null)
				   return currentJoueur.getId();
			  else if(nbmove == 9) 
					  return 3;
				  
				  swapTurn();
		return 4;
	      
}
	    public int gamePlayer() {
	    	return currentJoueur.getId();
	    }

	
	   
}