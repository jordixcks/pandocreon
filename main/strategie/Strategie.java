package main.strategie;

import java.util.ArrayList;

import main.carte.Carte;
import main.principal.*;

/**
 * <b>Strategie est la classe d'interface qui contient la methode permettant aux joueurs IA de jouer avec des strat�gies diff�rentes.</b>
 */
public interface Strategie{
	
	

	/**
	 * D�finit le d�roulement de la strat�gie, afin de choisir une action.
	 */
	public int choisirCarte(ArrayList<Joueur> joueur, int j, ArrayList<Carte> collectionCarte, ArrayList<Carte> table);
	
	
}
