package moprion.Joueur;
import morpion.grille.Jetons;
public class Joueur {
	///// tous les champs
	 private int id;  //// l identifiant de joueur 
	 private Jetons caractere; //// son caractere )
	 
	
	//// constructeur 
	 public Joueur(int playerId ,char c ) {
		 this.id=playerId;
		 this.caractere = new Jetons(c,this ) ;
	 }
	 /// Getters et setters 


	public Jetons getCaractere() {
		return caractere;
	}
	  
	//// methodes
	/// pour comparer deux joueur pr verifier le gagnant 
	@Override
	public boolean equals(Object others) {
		if (others == null)
			return false ;
		if(others instanceof Joueur ) { // verrifier si others et bien de Joueur
			Joueur joueur = (Joueur)others; // cast de others to Joueur object
			 return joueur.id == this.id ;
		}else 
			return false;
		
		
	}
	
}
