package main.principal;

import java.util.ArrayList;
import main.carte.*;



/**
 * <b>Plateau est la classe représentant la plateau de jeu avec les cartes qu'il contient.</b>
 */
public class Plateau {
	private ArrayList<Carte> cartePlateau;
	
	/**
	 * Contructeur Plateau.
	 */
	public Plateau(){
		cartePlateau = new ArrayList<Carte>();
		
	}
	
	/**
	 * Retourne la collection de carte du plateau.
	 * @return cartePlateau
	 */
	public ArrayList<Carte> getCartePlateau(){
		return cartePlateau;
	}
	
}
