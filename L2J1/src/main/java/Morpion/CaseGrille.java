package Morpion;

public class CaseGrille {
////////tous le champs 
	
 ///// le id de la case 
	private int  caseId ;
	/////// le contenu de la case X ou O 
	private Jetons contenu;

/////// contructeur 
public CaseGrille(int caseId) {
	this.caseId = caseId;
	this.contenu = null; // car y a pas de jetons a mettre des le debut 
	
}
public CaseGrille(int caseId , Jetons contenu) {
	this.caseId = caseId;
	this.contenu = contenu;
}
///Getter // Setter 

public Joueur getPrioritairejetons() {
	if(contenu != null)
	return contenu.getProprietaire();
	else
		return null;
}


public void setContenu(Jetons contenu) {
	this.contenu = contenu;
}
////// Methodes
/// verifier si la case est rempler ou pas 
public boolean estVide() {
	return this.contenu == null;
}
@Override
public String toString() {
	if (this.contenu != null)
	return this.contenu.toString() ;
	else 
	 return Integer.toString(caseId);
	 
}

}