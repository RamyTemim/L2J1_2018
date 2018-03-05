package morpion.grille;
import moprion.Joueur.Joueur;
public class Jetons {
	//////// tous le champs 
	private char car;
	private Joueur  proprietaire ;
	/////// contructeur 
	public Jetons(char car, Joueur proprietaire) {
		this.car=car;
		this.proprietaire = proprietaire ;
	}
	
	
	////// getter et setters 
	public Joueur getProprietaire() {
		return proprietaire;
	}
	
	////// Methodes
	
	///// afficher les jetons 
	 @Override 
	 public String toString() {
		 // convertir le resultat en String 
		 return Character.toString(this.car);
	 }


	


	
}
