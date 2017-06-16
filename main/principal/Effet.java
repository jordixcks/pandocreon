package main.principal;

import java.util.*;
import main.principal.Joueur;
import main.carte.*;
/**
 * <b>Effet est la classe d'interface qui contient les m�thodes pour activer les effets des cartes.</b>
 */
public interface Effet {
	

	/**
	 * Actionne l'effet de la carte.
	 * 
	 * @param listejoueur
	 * 			La liste des joueurs de la partie.
	 * @param cible
	 * 			La joueur contre qui l'effet sera jou�.
	 * @param table
	 * 			Collection de cartes situ�es au centre de la table de jeu.
	 * @param carte
	 * 			La carte qui joue l'effet.
	 * @param j
	 * 			Le joueur qui joue la carte.
	 * @param collection
	 * 			Le deck de cartes.
	 * @param tourjoueur
	 * 			La liste des joueurs selon l'ordre de jeu.
	 */
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j , ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur);

	/**
	 * Actionne l'effet de la Divinit�.
	 * 
	 * @param listejoueur
	 * 			La liste des joueurs de la partie.
	 * @param cible
	 * 			La joueur contre qui l'effet sera jou�.
	 * @param table
	 * 			Collection de cartes situ�es au centre de la table de jeu.
	 * @param j
	 * 			Le joueur qui joue la carte.
	 * @param collection
	 * 			Le deck de cartes.
	 * @param tourjoueur
	 * 			La liste des joueurs selon l'ordre de jeu.
	 */
	void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection, ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur);
}
