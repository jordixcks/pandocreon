package main.effet;

import java.util.ArrayList;
import main.principal.*;
import main.carte.*;

/**
 * <b>Effet6 est la classe representant l'effet des carte 13, 35.</b>
 * <p>Son effet : On relance le dé.
.</p>
 */
public class Effet6 implements Effet { 



	@Override
	/**
	 * Actionne l'effet de la carte.
	 * 
	 * @param listejoueur
	 * 			La liste des joueurs de la partie.
	 * @param cible
	 * 			La joueur contre qui l'effet sera joué.
	 * @param table
	 * 			Collection de cartes situées au centre de la table de jeu.
	 * @param carte
	 * 			La carte qui joue l'effet.
	 * @param j
	 * 			Le joueur qui joue la carte.
	 * @param collection
	 * 			Le deck de cartes.
	 * @param tourjoueur
	 * 			La liste des joueurs selon l'ordre de jeu.
	 */
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte,
			int j, ArrayList<Carte> collection,ArrayList<Joueur> tourjoueur) {
		listejoueur.get(j).lancerDe(listejoueur);
		
		System.out.println("Effet: Le joueur " +j+ " relance le dé de Cosmogonie");
		
	}

@Override
public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
		ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
	// TODO Auto-generated method stub
	
}



}
