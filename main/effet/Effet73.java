package main.effet;

import java.util.ArrayList;

import main.carte.Carte;
import main.principal.Effet;
import main.principal.Joueur;

/**
 * <b>Effet73 est la classe representant l'effet de la carte 73.</b>
 * <p>Son effet : Retourne les effets d'une carte d'Action sur le Divinité qui l'a posée.</p>
 */
public class Effet73 implements Effet{

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
	public void utiliserEffet(ArrayList<Joueur> listejoueur, int cible, ArrayList<Carte> table, Carte carte, int j,
			ArrayList<Carte> collection, ArrayList<Joueur> tourjoueur) {
		if (tourjoueur.get(j).isEffetMiroir()==false){
			tourjoueur.get(j).setEffetMiroir(true);
		}
		
	}

	@Override
	public void utiliserEffetDivinite(ArrayList<Joueur> listejoueur, int j, ArrayList<Carte> collection,
			ArrayList<Carte> table, int cible, ArrayList<Joueur> tourJoueur) {
		// TODO Auto-generated method stub
		
	}

}
