package Morpion;

public class Game {
	private Grille grille;
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur currentJoueur;

	// constructeur

	public Game() {
		this.grille = new Grille();
		this.joueur1 = new Joueur(1, 'X');// premier joueur avec le O
		this.joueur2 = new Joueur(2, 'O');// deuxieme joueur avec le x

	}

	public Game(Grille grille, Joueur joueur1, Joueur joueur2, Joueur currentJoueur) {
		this.grille = new Grille();
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.currentJoueur = currentJoueur;

	}

	// Getter et Setter

	public Grille getGrille() {
		return grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
	}

}