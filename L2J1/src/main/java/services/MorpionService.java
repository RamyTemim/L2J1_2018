package services;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Morpion.CaseGrille;
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
	    
/////////// reset grille;
<<<<<<< HEAD
<<<<<<< HEAD
    @JsonIgnore
=======
	   // @JsonIgnore
>>>>>>> cdca94bf424de54d18291669a895bc01440a7eeb
=======
	   @JsonIgnore
>>>>>>> ae31a70908bf8d28e4d008d09aa6874500986681
	public int  clear(int rep) {
		if (rep == 1) {
		for (int i = 0; i < 9; i++) {
			if (grille.getCaseContenu(i)== null)
			    grille.setCaseContenu(i, null);
	        else 
			this.grille.setCaseContenu(i, null);
			
		}
<<<<<<< HEAD
<<<<<<< HEAD
		 currentJoueur = joueur1;
=======
		 //currentJoueur.setId(joueur1.getId());
>>>>>>> cdca94bf424de54d18291669a895bc01440a7eeb
=======
		 currentJoueur = joueur1;
>>>>>>> ae31a70908bf8d28e4d008d09aa6874500986681
		}
			return 4;
	
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
					tmp = Min(grille,profondeur-1);
					if (tmp > max )
						id = i;
				}
				// on annule le coup
				grille.setCaseContenu(i, null);
	
			}
	        grille.setCaseContenu(id, joueur1.getCaractere());
	      
	        return id;
			}
	    
	  public int Min(Grille grille,int p) {
		  if (p == 0 || grille.getGagnant() != null ) {
			  return eval(grille);
		  }
		  int min = 1000;
		  int i;
		  int temp;
		  for ( i = 0; i < 9; i++) {
			  if (grille.getCaseContenu(i)==null) {
				  grille.setCaseContenu(i, joueur1.getCaractere());
				  temp = Max(grille,p-1);
				  if (temp < min ) {
					  min = temp;
				  }
				  grille.setCaseContenu(i,null);
			  }
		}
		  return min;
	  }
	public int Max(Grille  grille ,int p) {
		if (p==0 || grille.getGagnant()!= null) {
			return eval(grille);
		}
		int max=-1000;
		int i,temp ;
		for ( i = 0; i < 9; i++) {
			if (grille.getCaseContenu(i)==null) {
				grille.setCaseContenu(i, joueur2.getCaractere());
				temp= Min(grille,p-1);
				if (temp > max ) {
					max=temp;
				}
				grille.setCaseContenu(i, null);
			
		}
		
	}
		return max;
	   
	    }
	public void nb_Series(int n) {
		int compteur1=0;
		int compteur2=0;
		int i ,j;
		/// diagonale descendante 
		for (i=0;i<=8;i=i+4) {
			if (grille.getCaseContenu(i).getProprietaire().getId() == 1 ) {
				compteur1++;
				compteur2=0;
				if(compteur1 == n ) {
					series_j1++;
				}
			}
			if (grille.getCaseContenu(i).getProprietaire().getId() == 2 ) {
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
			if (grille.getCaseContenu(i).getProprietaire().getId() == 1 ) {
				compteur1++;
				compteur2=0;
				if(compteur1 == n ) {
					series_j1++;
				}
			}
			if (grille.getCaseContenu(i).getProprietaire().getId() == 2 ) {
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
	public int eval(Grille grille) {
		int vainqueur,nb_de_Pions=0;
		int i;
		
		/// on compte le nombre de pions sur le plateau 
		  for ( i = 0; i < 9; i++) {
			  if(grille.getCaseContenu(i)==null) {
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
		  // on compte le nombre de series de 2 pions aliges de chacun des joueur 
		  nb_Series(2);
		  return series_j1 - series_j2;
	
	}
		
	
	    
   
}