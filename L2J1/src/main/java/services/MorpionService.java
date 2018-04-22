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
	 
	          int profondeur = 5;
	 
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
	    	int id = 10 ;
	        int i;
	       for ( i = 0; i < 9; i++) {
	        	///// si la case est vide on simule un coup 
				if (grille.getCaseContenu(i) == null) {
					grille.setCaseContenu(i, joueur1.getCaractere());
					 profondeur=profondeur -1;
					tmp = minIA(profondeur);
					
					if ((tmp > max)|| ((tmp == max) && (Math.random()%2 == 0)) )
						id = i;
					// on annule le coup
					grille.setCaseContenu(i, null);
				}
				
	
			}
	        grille.setCaseContenu(id, joueur1.getCaractere());
	        nbmove = nbmove+1;
	    
	      
	        return id;
			}
	    
	    
	    /////////////////////////////////
	    ///
	   ///    fonction min 
	  ///
	 //////////////////////////////////
	    
	    
	  public int minIA(int p) {
		  if (profondeur== 0 || grille.getGagnant() != null  || nbmove == 9) {
			  return eval();
		  }
		  int min = 1000;
		  int i;
		  int temp;
		  for ( i = 0; i < 9; i++) {
			  if (grille.getCaseContenu(i)== null) {
				  grille.setCaseContenu(i, joueur1.getCaractere());
				  profondeur=profondeur -1;
				  temp = maxIA(profondeur);
				  
				  if ((temp < min ) || ((temp == min) && (Math.random()% 2 == 0 ))) {
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
		if (profondeur==0 || grille.getGagnant()!= null || nbmove == 9) {
			return eval();
		}
		int max=-1000;
		int i,temp ;
		for ( i = 0; i < 9; i++) {
			if (grille.getCaseContenu(i)==null) {
				grille.setCaseContenu(i, joueur2.getCaractere());
				 profondeur=profondeur -1;
				temp= minIA(profondeur);
				if ((temp > max)  || ((temp == max) && (Math.random()%2 == 0))) {
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
	
	/*
	public void nb_Series(int n) {
		int compteur1=0;
		int compteur2=0;
		int i ,j;
		/// diagonale descendante 
		for (i=0;i<=8;i=i+4) {
			if (grille.getCaseContenu(i).getProprietaire() == joueur1 ) {
				compteur1++;
				compteur2=0;
				if(compteur1 == n ) {
					series_j1++;
				}
			}
			if (grille.getCaseContenu(i).getProprietaire() == joueur2 ) {
				compteur2++;
				compteur1=0;
				if(compteur2 == n ) {
					series_j2++;
				}
			}
		}
		compteur1=0;
		compteur2=0;
		// Diagonale Montante 
		for(i=2;i<=6;i=i+2) {
			if (grille.getCaseContenu(i).getProprietaire() == joueur1 ) {
				compteur1++;
				compteur2=0;
				if(compteur1 == n ) {
					series_j1++;
				}
			}
			if (grille.getCaseContenu(i).getProprietaire() == joueur2) {
				compteur2++;
				compteur1=0;
				if(compteur2 == n ) {
					series_j2++;
				}
		}
		
	}
		///// en ligne 
		for(i=0;i<=6;i=i+3) {
			 compteur1 = 0;
	          compteur2 = 0;
	          ///// horizentale 
	          for(j=0;j<3;j=j++) {
	            if (grille.getCaseContenu(i+j).getProprietaire() == joueur1 ) {
	  				compteur1++;
	  				compteur2=0;
	  				if(compteur1 == n ) {
	  					series_j1++;
	  				}
	  			}
	  			if (grille.getCaseContenu(i+j).getProprietaire() ==joueur2 ) {
	  				compteur2++;
	  				compteur1=0;
	  				if(compteur2 == n ) {
	  					series_j2++;
	  				}
	  		    }
	          }   
		}
		
		
		 //// verticalement 
  		for(i=0;i<3;i++) {
  			compteur1 = 0;
	          compteur2 = 0;
	          for (j=0;j<=6;j=j+3) {
	        	  if (grille.getCaseContenu(i+j).getProprietaire().getId() == 1 ) {
		  				compteur1++;
		  				compteur2=0;
		  				if(compteur1 == n ) {
		  					series_j1++;
		  				}
		  			}
		  			if (grille.getCaseContenu(i+j).getProprietaire().getId() == 2 ) {
		  				compteur2++;
		  				compteur1=0;
		  				if(compteur2 == n ) {
		  					series_j2++;
		  				}
		  		    }
	          }
  		}
		
		
		}
	*/
		
	public int eval() {
		int vainqueur,nb_de_Pions=0;
		int i;
		
		/// on compte le nombre de pions sur le plateau 
		  for ( i = 0; i < 9; i++) {
			  if(grille.getCaseContenu(i) != null) {
				  nb_de_Pions++;
			  }
			
		}
		  if ( grille.getGagnant() != null ) {
			  vainqueur = grille.getGagnant().getId();
			  if(vainqueur == 1) {
				  return 1000- nb_de_Pions;
			  }else if (vainqueur == 2) {
				  return -1000 + nb_de_Pions;
			  }else 
				  return 0;
		  }
		
		 ///////// la partie en cours 
		return 4;
	
	}
	
	/*
	public int gagant (Grille g) {
		int i;
		int resu=3;
		nb_Series(3);
		if (series_j1 != 0) {
			
			resu = 1;
		}
		else if(series_j2 !=0 ) {
			resu = 2;
		}
			else {
				for (i=0;i<9;i++) {
					if (g.getCaseContenu(i) == null ) {
						resu = 0;
					}
				}
			}
		
		
	return resu ;
	}
		
*/
	    
   
}