package main.strategie;

import java.util.ArrayList;

import main.carte.Carte;
import main.principal.*;

/**
 * <b>Strategie est la classe d'interface qui contient la methode permettant aux joueurs IA de jouer avec des stratégies différentes.</b>
 */
public interface Strategie{
	
	

	/**
	 * Définit le déroulement de la stratégie, afin de choisir une action.
	 */
	public int choisirCarte(ArrayList<Joueur> joueur, int j, ArrayList<Carte> collectionCarte, ArrayList<Carte> table);
	
	
}
