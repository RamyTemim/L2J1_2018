package Morpion;



public class Grille {
////////tous les champs 
	 
private  CaseGrille [] grille ;
/////// contructeur 
public Grille (){
	this.grille = new CaseGrille[9];

	
	for (int i=0; i< this.grille.length;i++) {
		grille[i] = new CaseGrille(i);/// id de la case 
	}
}

/// getter setters 
/// recuperer le prioritaire de jetons id 

public Joueur  getJetProp(int indice ) {
	 return  this.grille[indice].getPrioritairejetons();
}

///// recuperer la contenue d une case dans la grille 
public Jetons getCaseContenu(int caseId) {
	return grille[caseId].getContenu();
}

/// modifier le contenue d une case dans la grille 
public void setCaseContenu(int caseId ,Jetons contenu) {
	 this.grille[caseId].setContenu(contenu);
}


////// Methodes
/// methode priver pour une bonne laisibiliter de code auteur
/// de la methode getGagnant 

private  Joueur getLine() {
	Joueur winner = null;
	for ( int row = 0; row < 3; row++) {
		Joueur joueur =  getJetProp(row*3);
	 if (joueur != null && joueur.equals(getJetProp(1+ row*3))) {
		 if (joueur != null && joueur.equals(getJetProp(2+row*3))) {
			 winner = joueur ;
			 break;
		 }
		 
	 }
	}
	return winner;
}

private Joueur getCol() {
	Joueur winner = null;
	for (int col = 0; col < 3 ; col++) {
		Joueur joueur =  getJetProp( col + 0 * 3);
	 if ( joueur != null &&  joueur.equals(getJetProp(1 * 3 + col))) {
		 if (joueur.equals(getJetProp(2 * 3 +col))) {
			 winner = joueur ;
			 break;
		 }
		 
	 }
	}
	return winner;
}

///// renvoie le gagnant 
public Joueur getGagnant () {
	Joueur winner = null;
	winner = getLine();
	if (winner != null )
		return  winner;
	winner = getCol();
	if (winner != null)
		return  winner;
	/// comparaison diagonale  753
	 Joueur joueur =  getJetProp( 0 );
	 if ( joueur != null && joueur.equals(getJetProp(4))) {
		 if (joueur.equals(getJetProp(8))) {
			 winner = joueur ;
		 }
		 
	 }
	/// comparaison diagonale  951 
		 joueur =  getJetProp(0);
		 if (joueur != null && joueur.equals(getJetProp(4))) {
			 if (joueur.equals(getJetProp(6))) {
				 winner = joueur ;
			 }
			 
		 }
	 
	 return winner;
	}

/////////// reset grille;
	public void clear() {
		for (int i = 0; i < grille.length; i++) {
			if (this.grille[i]== null)
			this.grille[i] = new CaseGrille(i);
	        else 
			this.grille[i].setContenu(null);
	}
	}



///// verifier si la grille est bien remplie 
//// sert a fire c un match est nul ou pas 
public boolean estPlein() {

	boolean plein = true;
	for (int i = 0; i < grille.length; i++) {
		if (grille[i].estVide()) {
			plein = false;
			break;
		}
	}
	return plein;
	

}

}