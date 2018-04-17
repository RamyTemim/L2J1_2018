package Morpion;

public class Game {
	/// tous les champs 
		 private Grille grille;
		 private Joueur joueur1;
		 private Joueur joueur2;
		 private Joueur currentJoueur;
		 private  String gameType;
		 
	
///// constructeur 
		 
	 public Game () {
		 this.grille = new Grille();
		 this.joueur1 = new Joueur(1, 'X');// premier joueur avec le O
		 this.joueur2 = new Joueur(2, 'O');// deuxieme joueur avec le x 
		 
}
public Game(Grille grille, Joueur joueur1, Joueur joueur2, Joueur currentJoueur, String gameType) {
	this.grille = new Grille();
	this.joueur1 = joueur1;
	this.joueur2 = joueur2;
	this.currentJoueur = currentJoueur;
	this.gameType = gameType;
}

/////////////////  SETTER AND GETTER ////////////////////////

public void setGameType(String gameType) {
	this.gameType = gameType;
}

public String getGameType() {
	return gameType;
}
public Grille getGrille() {
	return grille;
}
public void setGrille(Grille grille) {
	this.grille = grille;
}





/*
public void start() {
	MorpionService gameService = new MorpionService();
	gameService.afficherGrille();

		 
	
		 // pour modifier la grille 
		/// System.out.println(this.grille.toString());
		 // pour lire un charactere 
		 
		 this.grille.setCaseContenu( input, this.currentJoueur.getCaractere());
		 
		   if(this.grille.getGagnant() != null) {
			 gameService.status(currentJoueur);
			  System.out.println("le joueur "+ currentJoueur.getCaractere()+ " a gagner bravo !!");
			  break;
			// a current player won
		  }else if (this.grille.estPlein()== false) 
		  {
			 // afficherGrille();
			  if(this.grille.estPlein() == true) {
		
			  System.out.println(" Drawwwww ");
			 break;
			  }
	 }
			  //match null
			  
	   swapTurn(); 
      }  
	 scan.close();*/
	
}
 ///refaire le jeu
// il ne faut une methode resete dans la  classe grille 
/*
public void reset () {
	this.grille.clear();
	
}
*/
