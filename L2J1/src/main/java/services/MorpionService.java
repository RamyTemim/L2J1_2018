package services;

import com.fasterxml.jackson.annotation.JsonIgnore;


import Morpion.CaseInput;
import Morpion.Game;
import Morpion.Grille;
import Morpion.Joueur;
import Morpion.Reset;
import Morpion.TypeGame;




public class MorpionService {
	
	 Game game = new Game();
	 Joueur progress = new Joueur(4);
	 Grille grille = new Grille();
	 Joueur  joueur1 = new Joueur(1, 'X');
	 Joueur joueur2 = new Joueur(2, 'O');
	 Joueur currentJoueur = joueur1;
	 int status=4;
	 int nbmove = 0;
	 
	 int series_j1=0;
	 int series_j2=0;
	 
	 
	 /// innitialiser le niveau de difficulter de l ia 
	 
	          int profondeur = 9;
	          
	          
	          ///////  renvoie la position ia 
	          int idcase;
	 
	 //////////////////////////////////////////////////////////////
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
	    	 
			   if(grille.getGagnant() != null ) {
				   if (currentJoueur.getId()==1)
					   status =1;
				   else if (currentJoueur.getId()==2)
					   status =2;
				  
				   
				   return status ;
			   } else if (nbmove >= 9) {
				   status =3;
				   
			   }
	        
				  
				  swapTurn();
		 return status;
	      
}
	    public int gamePlayer() {
	    	return currentJoueur.getId();
	    }
	    
/////////// reset grille;

    @JsonIgnore

	public int   clear(Reset rep) {
		if (rep.getRep() == 1) {
		for (int i = 0; i < 9; i++) {
			    grille.setCaseContenu(i, null);
			
		}

		 currentJoueur = joueur1;

		
		    status =4;
		    nbmove=0;
		    
		}
	 return status ;
	
	}
	    
	    //////////////////////////////////////////////////////////////////////////////////////////////////////////
	    //////////////                                                                     //////////////////////
	    /////////////                         l intelegence artificiel                     //////////////////////
	    /////////////                                                                      //////////////////////
	    ////////////////////////////////////////////////////////////////////////////////////////////////////////
	    
	    public int iaMove() {
	    	int max = -1000;
	    	int tmp;
	    	int depth = profondeur;
	        int i;
	       for ( i = 0; i < 9; i++) {
	        	///// si la case est vide on simule un coup 
				if (grille.getCaseContenu(i) == null) {
					grille.setCaseContenu(i, joueur2.getCaractere());
	
					tmp = minIA( depth-1 );
					
					if ((tmp > max)|| (tmp == max )) {
						idcase = i;
						max=tmp;
						
					}
					// on annule le coup
					grille.setCaseContenu(i, null);
				}
				
	
			}
	        grille.setCaseContenu(idcase, joueur2.getCaractere());
	        nbmove = nbmove+1;
	    
	      
	        return idcase;
			}
	    
	    
	    /////////////////////////////////
	    ///
	   ///    fonction min 
	  ///
	 //////////////////////////////////
	    
	    
	  public int minIA(int p) {
		  if (p== 0 || grille.getGagnant() != null  || nbmove == 9) {
			  return eval();
		  }
		  int min = 1000;
		  int i;
		  int temp;
		  for ( i = 0; i < 9; i++) {
			  if (grille.getCaseContenu(i) == null) {
				  grille.setCaseContenu(i, joueur2.getCaractere());
				
				  temp = maxIA(p-1);
				  
				  if ((temp < min )|| (temp == min) ) {
					  min = temp;
				  }
				  grille.setCaseContenu(i,null);
			  }
		}
		  return min;
	  }
	  
	  ///////////////////////////////////////
	  //////
	  /////    fonction max 
	  ////
	  ///////////////////////////////////////
	  
	  
	public int maxIA(int p) {
		if (p==0 || grille.getGagnant()!= null || nbmove == 9) {
			return eval();
		}
		int max=-1000;
		int i,temp ;
		for ( i = 0; i < 9; i++) {
			if (grille.getCaseContenu(i) == null) {
				grille.setCaseContenu(i, joueur1.getCaractere());
	
				temp= minIA(p-1);
				if ((temp > max) || (temp == max) ) {
					max=temp;
				}
				grille.setCaseContenu(i, null);
			
		}
		
	}
		return max;
	   
	    } 
	/////////////////////////////////////////////////////////
	////////
	///////   fonction evalution 
	//////
	/////////////////////////////////////////////////////////

	
	public int eval() {
		int vainqueur=0;
		int nb_piont=0;
		for (int i=0;i<9;i++) {
			if (grille.getCaseContenu(i)!= null)
				nb_piont++;
		}
	
		  if ( grille.getGagnant() != null ) {
			  vainqueur = grille.getGagnant().getId();
			  if(vainqueur == 2) {
				  return  100 - nb_piont;
			  }else if (vainqueur == 1) {
				  return -100 + nb_piont;
			  }
				
		  }
			 return vainqueur;
	
	}
	
	
   
}