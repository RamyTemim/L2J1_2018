package pfc;

import java.util.Random;


public class pfc {
	private int joueur;
	private int bot;
	private int resultat;
	
	public pfc (int joueur, int bot) {
		this.joueur = joueur;
		this.bot = bot;
	}
	
	public pfc() {
		
	}

	public int getJoueur() {
		return joueur;
	}

	public void setJoueur(int joueur) {
		this.joueur = joueur;
	}

	public int getBot() {
		return bot;
	}

	public void setBot(int bot) {
		this.bot = bot;
	}
	
	public int generateBot() {
		Random rand = new Random();
		this.bot = rand.nextInt(3) + 1;
		return bot;
	}
	
	public int resultat() {
		
		this.setBot(this.generateBot());
		
		if ((joueur==1)&&(bot==1)) {
			resultat = 3;
		}
		else if ((joueur==1)&&(bot==2)) {
			resultat = 2;
		}
		else if ((joueur==1)&&(bot==3)) {
			resultat = 1;
		}
		else if ((joueur==2)&&(bot==1)) {
			resultat = 1;
		}
		else if ((joueur==2)&&(bot==2)) {
			resultat = 3;
		}
		else if ((joueur==2)&&(bot==3)) {
			resultat = 2;
		}
		else if ((joueur==3)&&(bot==1)) {
			resultat = 2;
		}
		else if ((joueur==3)&&(bot==2)) {
			resultat = 1;
		}
		else if ((joueur==3)&&(bot==3)) {
			resultat = 3;
		}
		return resultat;		
	}
	
    public int markMove(int idcase) {
    	this.setJoueur(idcase);
    return  idcase;
		 
    }
    
    public int reset(int rep) {
    	if (rep==1) {
    	this.setJoueur(0);
    	this.setBot(0);
    	}
    return this.resultat = 0;
    }
}
