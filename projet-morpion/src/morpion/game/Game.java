package morpion.game;
import morpion_joueur.Joueur.*;
import java.util.Scanner;
import morpion.grille.Grille;
import saisie.Input;

public class Game {
	/// tous les champs 
	 private Grille grille;
	 private Joueur joueur1;
	 private Joueur joueur2;
	 private Joueur currentJoueur;
	 
	///// constructeur 
	 public Game () {
		 this.grille = new Grille();
		 this.joueur1 = new Joueur(0, 'O');// premier joueur avec le O
		 this.joueur2 = new Joueur(1, 'X');// deuxieme joueur avec le x 
		 
	 }
	//// methodes 
	 
	 // methode priver 
	 
	 //// tour a tour pour jouer 

private void swapTurn() {
	if (this.currentJoueur.equals(this.joueur1))
		this.currentJoueur = joueur2;
	else
		this.currentJoueur = joueur1;
	
}
// controler l entre des donnee
 private int getUserInput (Scanner scan ) {
	int  input = -1;
	 while (true) {
		 System.out.println("c a votre tour de jouer  joueur "+this.currentJoueur.getCaractere());
	     input = Input.readInt(scan);
	   if ( (0 <= input) && (input <= 8) )
		 break;
	 }
	return input;
 }
 private void afficherGrille() {
	 System.out.println(this.grille);
	 
 }
	 
	// lancer le jeu
	public void start() {
		Scanner scan = new Scanner(System.in);
		 currentJoueur = this.joueur1;
		 while(true) {
			 
			 ///affficher la frille 
			 afficherGrille();
			 System.out.flush();
			 // pour modifier la grille 
			/// System.out.println(this.grille.toString());
			 // pour lire un charactere 
			 
			 int input = getUserInput(scan);
			 this.grille.setCaseContenu( input, this.currentJoueur.getCaractere());
			 
			   if(this.grille.getGagnant() != null) {
				  afficherGrille();
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
		 scan.close();
		
	}
	 ///refaire le jeu
	// il ne faut une methode resete dans la  classe grille 
	public void reset () {
		this.grille.clear();
		
	}
}
